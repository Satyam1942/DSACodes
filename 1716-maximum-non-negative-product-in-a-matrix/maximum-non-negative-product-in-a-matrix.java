class Solution {
    void rec(int curRow, int curCol, int [][] grid, HashSet<Long> set , long sum)
    {
        if(curRow==grid.length-1 && curCol==grid[0].length-1) 
        {
            sum*=grid[curRow][curCol];
            if(sum>=0)set.add(sum);
            return;
        }  

        if(grid[curRow][curCol]==0) {set.add(0l); return;}

        if(curRow+1<grid.length) rec(curRow+1,curCol,grid,set,sum*grid[curRow][curCol]);
        if(curCol+1<grid[0].length) rec(curRow,curCol+1,grid,set,sum*grid[curRow][curCol]);
    }

    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long mod =(long)(1e9+7);
        
        long sum = 1l;
        HashSet<Long> set = new HashSet<>();
        
        rec(0,0,grid,set,sum);
   
        long ans = -1l;
        for(long i:set) ans = Math.max(ans,i);
    
        return (int)(ans%mod);

    }
}

/*
    -1  3  0
     3 -2  3
    -1  1 -4
 */