class Solution {  
    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int mini = Integer.MAX_VALUE;
        Integer dp[][] = new Integer[m][n];

        for(int i=0;i<n;i++) dp[m-1][i] = matrix[m-1][i];

        for(int row = m-2;row>=0;row--)
        {
        for(int col = n-1;col>=0;col--)
        {
        int temp1=Integer.MAX_VALUE,temp2=Integer.MAX_VALUE,temp3=Integer.MAX_VALUE;
        
        if(row+1<m) temp1 = dp[row+1][col];
        if(row+1<m && col+1<n) temp2 =  dp[row+1][col+1];
        if(row+1<m && col-1>=0) temp3 = dp[row+1][col-1];

        int down = (temp1!=Integer.MAX_VALUE)? matrix[row][col] + temp1: temp1;
        int rightDiag = (temp2!=Integer.MAX_VALUE)? matrix[row][col]  + temp2: temp2 ;
        int leftDiag = (temp3!=Integer.MAX_VALUE)? matrix[row][col] + temp3: temp3 ;

        dp[row][col] = Math.min(down,Math.min(leftDiag,rightDiag));
        }
        }

        for(int i=0;i<n;i++) mini = Math.min(mini,dp[0][i]);

        return mini;

    }
}