class Solution {
 
    public int uniquePaths(int m, int n) {
     int dp[][] =new int[m][n];

     dp[m-1][n-1] =1;

     for(int row=m-1;row>=0;row--)
     {
         for(int col=n-1;col>=0;col--)
         {
             if(row==m-1 && col==n-1)continue;

                 int down=0,right=0;
                 if(row+1<m)
                down = dp[row+1][col];
                if(col+1<n)
                 right = dp[row][col+1];
         
                dp[row][col]= down+right;
        }
     }

        return dp[0][0];

    }
}