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

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
      
        int m = matrix.length;
        int n = matrix[0].length;

        NumMatrix sumClass = new NumMatrix(matrix);
        int count =0;
        for(int row1=0;row1<m;row1++)
        {
            for(int row2=row1;row2<m;row2++)
            { 
              HashMap<Integer,Integer> storeSumFreq = new HashMap<>();
              storeSumFreq.put(0,1);
               int col=0,tempSum=0;
                while(col<n)
                {
                 tempSum += sumClass.sumRegion(row1,col,row2,col);
                 count+=storeSumFreq.getOrDefault(tempSum-target,0);
                 storeSumFreq.put(tempSum,storeSumFreq.getOrDefault(tempSum,0)+1);
                 col++;
                }
            }
        }

        return count;
    }
}