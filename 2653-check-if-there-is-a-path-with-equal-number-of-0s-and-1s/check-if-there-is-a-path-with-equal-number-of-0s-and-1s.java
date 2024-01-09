class Solution {
    boolean equalPath(int row, int col, int sum, int grid[][], Boolean cache[][][]) {

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            if (grid[row][col] == 0)
                sum -= 1;
            else
                sum += 1;

            return sum == 0;
        }

        if (cache[row][col][sum+(grid.length+grid[0].length)] != null)
            return cache[row][col][sum+(grid.length+grid[0].length)];

        boolean down = false, right = false;

        int increment = (grid[row][col] == 0) ? -1 : 1;

        if (row + 1 < grid.length)
            down = equalPath(row + 1, col, sum + increment, grid, cache);
        if (col + 1 < grid[0].length)
            right = equalPath(row, col + 1, sum + increment, grid, cache);

        return cache[row][col][sum+(grid.length+grid[0].length)] = down || right;
    }

    public boolean isThereAPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Boolean cache[][][] = new Boolean[m][n][2*(m+n)];
       
       boolean res =  equalPath(0, 0, 0, grid, cache);
        return res;
    }
}