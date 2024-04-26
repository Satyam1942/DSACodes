class Solution {
    int fallingPathSum(int curRow, int prevCol, int [][] grid, Integer cache[][]){
        if(curRow==grid.length)
            return 0;
        if(cache[curRow][prevCol+1]!=null)
            return cache[curRow][prevCol+1];

        int sum = Integer.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            if(i==prevCol)
                continue;
            int temp = grid[curRow][i]+fallingPathSum(curRow+1,i,grid,cache);
            sum = Math.min(sum,temp);
        }

        return cache[curRow][prevCol+1] =  sum;
    }
    public int minFallingPathSum(int[][] grid) {
        Integer cache[][] = new Integer[grid.length][grid[0].length+1];
        return fallingPathSum(0,-1,grid,cache);
    }
}

/*

 */