class Solution {
    int rec(int row,int col ,int matrix[][],int m, int n, Integer dp[][])
    {
        if(row == m-1) return dp[row][col] = matrix[row][col];

        if(dp[row][col]!=null) return dp[row][col];

        int temp1=Integer.MAX_VALUE,temp2=Integer.MAX_VALUE,temp3=Integer.MAX_VALUE;
        if(row+1<m) temp1 = rec(row+1,col,matrix,m,n,dp);
        if(row+1<m && col+1<n) temp2 =  rec(row+1,col+1,matrix,m,n,dp);
        if(row+1<m && col-1>=0) temp3 = rec(row+1,col-1,matrix,m,n,dp);

        int down = (temp1!=Integer.MAX_VALUE)? matrix[row][col] + temp1: temp1;
        int rightDiag = (temp2!=Integer.MAX_VALUE)? matrix[row][col]  + temp2: temp2 ;
        int leftDiag = (temp3!=Integer.MAX_VALUE)? matrix[row][col] + temp3: temp3 ;

        return dp[row][col] = Math.min(down,Math.min(leftDiag,rightDiag));
    }

    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int mini = Integer.MAX_VALUE;
        Integer dp[][] = new Integer[m][n];

        for(int i=0;i<n;i++)
        {
            int temp = rec(0,i,matrix,m,n,dp);
            System.out.println(temp);
            mini = Math.min(mini,temp);
        }     

        return mini;

    }
}