class Triplet
{
	int start,end,profit;

    Triplet(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

class Solution {
    int maximumProfit(int index, Triplet jobInfo[], Integer cache[]) {
        if (index >= jobInfo.length)
            return 0;
        if (cache[index] != null)
            return cache[index];

        int notTake = 0 + maximumProfit(index + 1, jobInfo, cache);

        int left = index + 1;
        int right = jobInfo.length - 1;

        int curStart = jobInfo[index].start;
        int curEnd = jobInfo[index].end;

        int nextIndex = jobInfo.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int start = jobInfo[mid].start;
            int end = jobInfo[mid].end;

            if (start >= curEnd) {
                right = mid - 1;
                nextIndex = mid;
            } else
                left = mid + 1;
        }

        int take = jobInfo[index].profit + maximumProfit(nextIndex, jobInfo, cache);
        int res = Math.max(take, notTake);

        return cache[index] = res;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int noOfJobs = profit.length;
        Triplet jobInfo[] = new Triplet[noOfJobs];
        for (int index = 0; index < noOfJobs; index++) {
            jobInfo[index] = new Triplet(startTime[index], endTime[index],
                    profit[index]);
        }

        Arrays.sort(jobInfo, (a, b) -> ((a.start == b.start) ? 
                                        a.end - b.end : a.start - b.start));

        Integer cache[] = new Integer[noOfJobs];
        int res = maximumProfit(0, jobInfo, cache);

        return res;

    }
}