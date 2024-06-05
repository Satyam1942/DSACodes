class Solution {
    long mod = (long)(1e9+7);
    long recursion(int curRow, int curCol, int isPathNegative, int grid[][], Long cache[][][]){
        if(curRow==grid.length-1 && curCol==grid[0].length-1)
            return grid[curRow][curCol];

        if(cache[curRow][curCol][isPathNegative]!=null)
            return cache[curRow][curCol][isPathNegative];

        long down = Long.MIN_VALUE ,right = Long.MIN_VALUE;
        int isCurValNegative = (grid[curRow][curCol]<0)? 1:0;
            
        if(curRow+1<grid.length)
            down =  recursion(curRow+1,curCol, Math.abs(isPathNegative-isCurValNegative), grid,cache);
        if(curCol+1<grid[0].length)
            right = recursion(curRow,curCol+1,Math.abs(isPathNegative-isCurValNegative), grid,cache);
     
        if(down!=Long.MIN_VALUE)
            down= down*(long)grid[curRow][curCol];
        if(right!=Long.MIN_VALUE)
            right= right*(long)grid[curRow][curCol];
            
        if(isPathNegative==0){
            if(down<0 && right<0)
                return cache[curRow][curCol][isPathNegative] = Long.MIN_VALUE;
            else
                return cache[curRow][curCol][isPathNegative] = Math.max(down,right);
        }
        else{
            
            if(down==Long.MIN_VALUE)
                down = Long.MAX_VALUE;
            if(right==Long.MIN_VALUE)
                right = Long.MAX_VALUE;

            if(down>0 && right>0)
                return cache[curRow][curCol][isPathNegative] = Long.MIN_VALUE;
            else
                return cache[curRow][curCol][isPathNegative] = Math.min(down,right);
        }
    }

    public int maxProductPath(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        Long cache[][][] = new Long[length][width][2];
        long res =  recursion(0,0,0,grid,cache);

        if(res==Long.MIN_VALUE)
            return -1;
        else
            return (int)(res%mod);
    }
}