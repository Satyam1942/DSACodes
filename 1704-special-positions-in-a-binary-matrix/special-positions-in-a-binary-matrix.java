class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int noOfZeroInRow[] = new int[m];
        int noOfZeroInCol[] = new int[n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    noOfZeroInRow[i]++;
                    noOfZeroInCol[j]++;
                }
            }
        }

        int count = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==1 && noOfZeroInRow[i]==n-1 && noOfZeroInCol[j]==m-1) count++;
            }
        }

        return count;
        
    }
}