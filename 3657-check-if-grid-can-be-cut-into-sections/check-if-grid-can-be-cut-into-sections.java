class Solution {
    boolean canCut(List<int[]> intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();
        Collections.sort(intervals, (a,b)->(a[0]-b[0]));
        int intervalCount = intervals.size();    
        int noOfCuts = 0;
        mergedIntervals.add(new int[]{intervals.get(0)[0], intervals.get(0)[1]});
   
        for(int i=1; i<intervalCount; i++) {
            int prevStart = mergedIntervals.get(mergedIntervals.size()-1)[0];
            int prevEnd = mergedIntervals.get(mergedIntervals.size()-1)[1];
            if(intervals.get(i)[0]>=prevEnd) {
                noOfCuts++;
                mergedIntervals.add(new int[]{intervals.get(i)[0], intervals.get(i)[1]});
            } else {
                int newStart = prevStart;
                int newEnd = Math.max(prevEnd, intervals.get(i)[1]);
                mergedIntervals.add(new int[]{ newStart, newEnd});    
            }
            if(noOfCuts==2) {
                return true;
            }
        }  
        return false;
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> horizontalCuts = new ArrayList<>();
        List<int[]> verticalCuts = new ArrayList<>();
        int noOfRectangles = rectangles.length;
        for(int i=0; i<noOfRectangles; i++) {
            int x1 = rectangles[i][0];
            int y1 = rectangles[i][1];
            int x2 = rectangles[i][2];
            int y2 = rectangles[i][3];
            horizontalCuts.add(new int[]{y1,y2});
            verticalCuts.add(new int[]{x1,x2});
        }
    
        boolean canCutHorizontally = canCut(horizontalCuts);
        boolean canCutVertically = canCut(verticalCuts);
        return canCutHorizontally || canCutVertically;
    }
}

/*
    for horizontal cuts => compare y
    for vertical cuts => compare x
    (0,2);(2,4);(2,3);(4,5)
    (0,2) (2,4) (4,5)
    cut = 2
*/