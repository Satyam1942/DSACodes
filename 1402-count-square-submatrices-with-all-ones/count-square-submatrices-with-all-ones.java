class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];

        for(int i=0;i<n;i++) 
        {
            if(matrix[0][i]==1) dp[0][i]= 1;
        }

        for(int j=0;j<m;j++) 
        {
            if(matrix[j][0]==1) dp[j][0] =1;
        }

        int delRow []={-1,0,-1};
        int delCol [] = {-1,-1,0};
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                int mini = Integer.MAX_VALUE;
                for(int k=0;k<3;k++)
                {
                    int newRow = i+delRow[k];
                    int newCol = j+delCol[k];
                   
                    mini = Math.min(mini,dp[newRow][newCol]);
                }
                
                if(matrix[i][j]==1) dp[i][j]=mini+1;
                else dp[i][j] =0;
                
            }
        }

        int sum=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                sum+=dp[i][j];
            }
        }

        return sum;
    }
}