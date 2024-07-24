class Solution {
    double rec(int row, int col, int poured, Double cache[][]){
        if(row==0 && col==0)
            return poured;
        if(cache[row][col]!=null)
            return cache[row][col];

        double leftUp = (col-1>=0)?rec(row-1,col-1,poured,cache):0;
        double rightUp = (col<=row-1)?rec(row-1,col,poured,cache):0;
     
        double leftFilled  = Math.max((leftUp-1)/2.0, 0);
        double rightFilled = Math.max((rightUp-1)/2.0,0);

        return cache[row][col] = leftFilled+rightFilled;
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        Double cache[][] = new Double[query_row+1][query_glass+1];
        double res =  rec(query_row, query_glass, poured,cache);
        return Math.min(1,res);
    }
}