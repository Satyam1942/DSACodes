class Solution {
    double rec(int poured , int query_row, int query_glass, Double [][] dp)
    {
        if(query_row < 0 || query_glass<0 || query_glass>query_row) return 0.0;

        if(query_row ==0 && query_glass==0) return dp[query_row][query_glass] = (double) poured;
       
        if(dp[query_row][query_glass]!=null) return dp[query_row][query_glass];

        double upLeft = rec(poured,query_row-1,query_glass-1,dp);
        double upRight = rec(poured, query_row-1,query_glass,dp);

        double leftRes = (upLeft-1)/2.0 ;
        double rightRes = (upRight-1)/2.0;

          if(leftRes<0) leftRes = 0.0;
          if(rightRes<0) rightRes = 0.0;

          return dp[query_row][query_glass] = leftRes+ rightRes;
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        Double dp[][] = new Double[100][100];
       return Math.min(1.0 ,rec(poured, query_row,query_glass,dp));
    }
}