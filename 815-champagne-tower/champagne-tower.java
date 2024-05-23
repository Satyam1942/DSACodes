class Solution {
    double filled(int poured, int queryRow, int queryGlass, Double cache[][]){
        if(queryRow<0 || queryGlass<0 || queryGlass>queryRow)
            return 0.0;
        if(queryRow==0 && queryGlass==0)
            return (double)poured;
        if(cache[queryRow][queryGlass]!=null)
            return cache[queryRow][queryGlass];
        
        double upLeft = filled(poured,queryRow-1,queryGlass-1,cache);
        double upRight = filled(poured,queryRow-1,queryGlass,cache);

        double leftRes = (upLeft-1)/2.0;
        double rightRes = (upRight-1)/2.0;

        if(leftRes<0)
            leftRes = 0.0;
        if(rightRes<0)
            rightRes = 0.0;

        return cache[queryRow][queryGlass] = leftRes+rightRes;           
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        Double cache[][] = new Double[100][100];
        double ans = filled(poured,query_row,query_glass,cache);
        return Math.min(1,ans);
    }
}