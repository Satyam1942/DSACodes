class Solution {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        List<int[]> mergedIntervals  = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));

        mergedIntervals.add(new int[]{intervals[0][0], intervals[0][1]});
        for(int i=1; i<length; i++) {
            int curStart= intervals[i][0];
            int curEnd = intervals[i][1];
            int prevStart = mergedIntervals.get(mergedIntervals.size()-1)[0];
            int prevEnd = mergedIntervals.get(mergedIntervals.size()-1)[1];
            if(curStart>prevEnd) {
                mergedIntervals.add(new int[]{curStart, curEnd});
            } else {
                int newEnd = Math.max(curEnd, prevEnd);
                mergedIntervals.set(mergedIntervals.size()-1, new int[]{prevStart, newEnd});
            }
        }

        int ans[][] = new int[mergedIntervals.size()][2];
        for(int i = 0; i<mergedIntervals.size(); i++) {
            ans[i] = mergedIntervals.get(i);
        }
        return ans;
    }
}