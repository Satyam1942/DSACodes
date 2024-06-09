class Solution {
    void createPrefixMatrix(int prefixSum[][] , int matrix[][]){
        int length = matrix.length;
        int width = matrix[0].length;
    
        int sum =0;
        for(int i=0;i<width;i++){
            sum += matrix[0][i];
            prefixSum[0][i] = sum;
        }

        for(int i=1;i<length;i++){
            sum = 0;
            for(int j=0;j<width;j++){
                sum+=matrix[i][j];
                prefixSum[i][j] = sum+prefixSum[i-1][j];
            }
        } 
    }
    int getPrefixSum(int i, int j, int k, int l, int prefixMatrix[][]){
       int max =  prefixMatrix[j][l];
       int upBoundary = (i==0)? 0:prefixMatrix[i-1][l];
       int leftBoundary = (k==0)?0: prefixMatrix[j][k-1];
       int diagonalBoundary = (i==0||k==0)?0:prefixMatrix[i-1][k-1];
       return max-upBoundary-leftBoundary+diagonalBoundary;
    }
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int length = matrix.length;
        int width = matrix[0].length;
        int prefixMatrix[][] = new int[length][width];

        createPrefixMatrix(prefixMatrix,matrix);

        int count = 0;
        for(int i=0;i<length;i++){
            for(int j=i;j<length;j++){
                HashMap<Integer,Integer> map = new HashMap<>();
                map.put(0,1);
                int sum = 0;
                for(int l=0;l<width;l++){
                    sum += getPrefixSum(i,j,l,l,prefixMatrix);
                    if(map.containsKey(sum-target)){
                        int freq = map.get(sum-target);
                        count+=freq;
                    }
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
            }
        }

        return count;
    }
}