class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int N = intervals.length;
        int[] start = new int[N];
        int[] stop = new int[N];
        
        for (int i = 0; i < N; i++) {
            int[] interval = intervals[i];
            start[i] = interval[0];
            stop[i] = interval[1];
        }
        Arrays.sort(start);
        Arrays.sort(stop);
        
        int i = 0;
        int j = 0;
        for (; i < N; i++) {
            if (stop[j] <= start[i]) {
                j++;
            } 
        }
        return i - j;
    }
}