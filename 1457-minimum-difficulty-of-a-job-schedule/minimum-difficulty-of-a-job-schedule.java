class Solution {
    int minimumDifficulty(int startIndex, int noOfPartitions, int jobDifficulty[], int noOfJobs,
            int suffixMaxDifficulty[], Integer cache[][]) {
        if (startIndex == noOfJobs)
            return Integer.MAX_VALUE;
        if (noOfPartitions == 0)
            return suffixMaxDifficulty[startIndex];
        

        if (cache[startIndex][noOfPartitions] != null)
            return cache[startIndex][noOfPartitions];

        int maxDiff = Integer.MIN_VALUE;
        int minDifficulty = Integer.MAX_VALUE;

        for (int idx = startIndex; idx < noOfJobs; idx++) {
            maxDiff = Math.max(jobDifficulty[idx], maxDiff);
            // partition
            int temp = minimumDifficulty(idx + 1, noOfPartitions - 1,
                    jobDifficulty, noOfJobs, suffixMaxDifficulty, cache);
            if(temp!=Integer.MAX_VALUE)  temp+=maxDiff;
            minDifficulty = Math.min(minDifficulty, temp);
        }

        return cache[startIndex][noOfPartitions] = minDifficulty;
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        int noOfJobs = jobDifficulty.length;
        int suffixMaxDifficulty[] = new int[noOfJobs];
        int maxi = 0;
        for (int idx = noOfJobs - 1; idx >= 0; idx--) {
            maxi = Math.max(maxi, jobDifficulty[idx]);
            suffixMaxDifficulty[idx] = maxi;
        }

        Integer cache[][] = new Integer[noOfJobs][d];

        int res = minimumDifficulty(0, d - 1, jobDifficulty, noOfJobs, suffixMaxDifficulty, cache);

        if (res == Integer.MAX_VALUE)
            return -1;
        else
            return res;

    }
}