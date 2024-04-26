class Solution {
    public int minFallingPathSum(int[][] grid) {
        int length = grid.length;
        for(int i=0;i<length-1;i++){
            int min = Integer.MAX_VALUE;
            int minCol = 0;
            int secondMin = Integer.MAX_VALUE;
            for(int j=0;j<length;j++){
                if(min>grid[i][j]){
                    secondMin = min;
                    min = grid[i][j];
                    minCol = j;
                }else if(secondMin>grid[i][j])
                    secondMin = grid[i][j];
            }

            for(int j=0;j<length;j++){
                if(j==minCol)
                    grid[i+1][j] += secondMin;
                else
                    grid[i+1][j] += min;
            }
        }

        int minSum = Integer.MAX_VALUE;
        for(int j=0;j<length;j++)
            minSum = Math.min(minSum,grid[length-1][j]);

        return minSum;
    }
}