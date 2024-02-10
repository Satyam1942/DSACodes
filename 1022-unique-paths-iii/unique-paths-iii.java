class Solution {
    boolean checkIfAllTraversed(int grid[][], int vis[][]) {
        int length = grid.length;
        int width = grid[0].length;
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == -1 || grid[row][col]==2)
                    continue;
                if (vis[row][col] == 0)
                    return false;
            }
        }
        return true;
    }

    int dfs(int curRow, int curCol, int vis[][], int grid[][]) {

        if (grid[curRow][curCol] == 2) {
            boolean res = checkIfAllTraversed(grid, vis);
            if (res)
                return 1;
            else
                return 0;
        }

        vis[curRow][curCol] = 1;

        int length = grid.length;
        int width = grid[0].length;

        int delRow[] = { 0, 1, 0, -1 };
        int delCol[] = { 1, 0, -1, 0 };

        int count = 0;
        for (int i = 0; i < 4; i++) {
            int adjRow = curRow + delRow[i];
            int adjCol = curCol + delCol[i];
            boolean isValid = adjRow >= 0 && adjRow < length &&
                    adjCol >= 0 && adjCol < width;
            boolean canGo = isValid && grid[adjRow][adjCol] != -1 &&
                    vis[adjRow][adjCol] != 1;
            if (canGo) {
                count += dfs(adjRow, adjCol, vis, grid);
            }
        }

        vis[curRow][curCol] = 0;
        return count;
    }

    public int uniquePathsIII(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        int vis[][] = new int[length][width];
        int startRow = -1, startCol = -1;

        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == 1) {
                    startRow = row;
                    startCol = col;
                    break;
                }
            }
        }

        int count = dfs(startRow, startCol, vis, grid);
        return count;

    }
}