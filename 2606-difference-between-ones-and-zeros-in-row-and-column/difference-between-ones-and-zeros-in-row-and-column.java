class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int oneRowCount[] = new int[m];
        int oneColCount[] = new int[n];


        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    oneRowCount[i]++;
                    oneColCount[j]++;
                }
            }
        }

        int diff[][] = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int noOfOnes = oneRowCount[i]+oneColCount[j];
                int noOfZeroes = (m-oneColCount[j]) + (n-oneRowCount[i]);
                diff[i][j] = noOfOnes-noOfZeroes;
            }
        }
        return diff;



    }
}