class Solution {
    int[][] createPrefixMatrix(int matrix[][]){
        int m = matrix.length;
        int n = matrix[0].length;
        int prefixMatrix[][] = new int[m+1][n+1];
        
        for(int i=0;i<m;i++){
            int prefixSumRow = 0;
            for(int j=0;j<n;j++){
                prefixSumRow+=matrix[i][j];
                prefixMatrix[i+1][j+1] = prefixSumRow+prefixMatrix[i][j+1];
            }
        }

        return prefixMatrix;
    }

    int sum(int row1,int col1, int row2, int col2, int prefixMatrix[][]){
        return prefixMatrix[row2+1][col2+1]-prefixMatrix[row1][col2+1] 
                -prefixMatrix[row2+1][col1] + prefixMatrix[row1][col1];
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
         int m = matrix.length;
         int n = matrix[0].length;

        int prefixSum[][] = new int[m+1][n+1];
        prefixSum = createPrefixMatrix(matrix);

        long count = 0;
        for(int row1=0;row1<m;row1++){
            for(int row2=row1;row2<m;row2++){
                HashMap<Integer,Integer> map = new HashMap<>();
                map.put(0,1);
                int tempSum = 0;
                for(int col1=0;col1<n;col1++){
                    tempSum += sum(row1,col1,row2,col1,prefixSum);
                    count+= map.getOrDefault(tempSum-target,0);
                    map.put(tempSum,map.getOrDefault(tempSum,0)+1);
                }
            }
        }
        return (int)count;
    }
}