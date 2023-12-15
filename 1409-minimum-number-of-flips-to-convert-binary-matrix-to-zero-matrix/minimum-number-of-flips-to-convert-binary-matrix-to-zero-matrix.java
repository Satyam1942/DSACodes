class Solution {
    int mini = Integer.MAX_VALUE;
    boolean isZeroMatrix(int mat[][])
    {
        int m = mat.length;
        int n = mat[0].length;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]!=0) return false;
            }
        }
        return true;
    }
    void flipMatrix(int [][] mat, int i, int j)
    {
         int m = mat.length;
        int n = mat[0].length;

        mat[i][j]= 1-mat[i][j];
        if(i+1<m) mat[i+1][j] = 1-mat[i+1][j];
        if(i-1>=0) mat[i-1][j] = 1-mat[i-1][j];
        if(j+1<n) mat[i][j+1] = 1-mat[i][j+1];
        if(j-1>=0) mat[i][j-1] = 1-mat[i][j-1];
    }

    void rec(int mat[][], int noOfSteps, int m ,int n, int vis[][])
    {
       
        if(isZeroMatrix(mat)) {mini = Math.min(mini,noOfSteps); return ;}
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(vis[i][j]==1) continue;
                int chosenRow = i;
                int chosenCol = j;
                vis[i][j]=1;
                flipMatrix(mat,i,j);
                rec(mat,noOfSteps+1,m,n,vis);
                flipMatrix(mat,i,j);
                vis[i][j]=0;
            }
        }
    }
    public int minFlips(int[][] mat) {
         int m = mat.length;
        int n = mat[0].length;
        int vis[][] = new int[m][n];

        rec(mat,0,m,n,vis);
        if(mini == Integer.MAX_VALUE) return -1;
        else return mini;
    }
}
/*
    [1,0,0]
    [0,0,0]

    [0,0,0]
    [0,0,0]
    [0,0,0]
 */