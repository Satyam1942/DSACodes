class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));

        int count = 0;
        int prevEnd = intervals[0][1];
        for (int idx = 1; idx < length; idx++) {
            int curStart = intervals[idx][0];
            int curEnd = intervals[idx][1];
            if (curStart < prevEnd)
            {
                count++;
            }
            else  prevEnd = curEnd;

        }

        return count;

    }
}
/*
    [1,11],
    [2,12],
    [11,22]
    [1,100],

    [1,4][1,3][2,3][3,4] 
    100,22,12
    4,4
1st
    -------------------             ---------------
                    -------------------

2nd
    -----------------------------------------------------------
                ------------        -------------------
3rd
    --------------------------------------------------------------
                    ------------------------------
                                            ------------------------
    
 */