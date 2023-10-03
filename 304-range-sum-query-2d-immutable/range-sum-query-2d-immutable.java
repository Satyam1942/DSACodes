class NumMatrix {
    int prefixSum[][];
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        prefixSum = new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            int prefixRow =0;
            for(int j=1;j<=n;j++)
            {
            prefixRow+=matrix[i-1][j-1];
            prefixSum[i][j] = prefixRow + prefixSum[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2+1][col2+1]-prefixSum[row1][col2+1]
                -prefixSum[row2+1][col1]+prefixSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */