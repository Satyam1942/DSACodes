class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for(int i=0;i<points.length-1;i++)
        {
            int difX = Math.abs(points[i][0]-points[i+1][0]);
            int difY= Math.abs(points[i][1]-points[i+1][1]);
            time+= Math.max(difX,difY);
        }   

        return time;
    }
}