class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points,(a,b)->(a[0]-b[0]));
        int widestArea = 0;
        for(int i=0;i<points.length-1;i++)
        {
            widestArea = Math.max(points[i+1][0]-points[i][0] , widestArea);
        }

        return widestArea;
    }
}