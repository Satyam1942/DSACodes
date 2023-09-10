class Solution {
    public int[][]  merge(int[][] intervals) {
    //    input: [[1,3],[2,6],[8,10],[15,18]]
    //    output: [[1,6],[8,10],[15,18]]
         
    //     List: [1,3] 1<2<3
    //           [1,6] 8>6 create a new interval 

        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        int length = intervals.length;
        List<int[]> mergedIntervals = new ArrayList<>();

        for(int index =0;index<length;index++)
        {
            int newStart = intervals[index][0];
            int newFinish = intervals[index][1];

            if(mergedIntervals.isEmpty() || 
            newStart>mergedIntervals.get(mergedIntervals.size()-1)[1])
            {
                mergedIntervals.add(intervals[index]);
            }
            else
            {
                int oldStart =  mergedIntervals.get(mergedIntervals.size()-1)[0];
                int oldFinish =  mergedIntervals.get(mergedIntervals.size()-1)[1];
                int mergedFinish = Math.max(newFinish,oldFinish);
                
                int newInterval[] = new int[2];
                newInterval[0] = oldStart;
                newInterval[1] = mergedFinish;

                mergedIntervals.set(mergedIntervals.size()-1,newInterval); 
            }
        }

        

        int[][] ans = new int[mergedIntervals.size()][2];
        int pointer =0;
        for(int[] interval:mergedIntervals)
        {
            ans[pointer] = interval;
            pointer++;
        }

        return ans;
    }
}