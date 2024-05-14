class Solution {
    int calculateGold(int curRow, int curCol, int vis[][], int grid[][]) {
        int length = grid.length;
        int width = grid[0].length;

        vis[curRow][curCol] = 1;
        int delRow[] = { -1, 0, 1, 0 };
        int delCol[] = { 0, 1, 0, -1 };
        int coins = 0;
        for (int i = 0; i < 4; i++) {
            int newRow = curRow + delRow[i];
            int newCol = curCol + delCol[i];
            boolean isValid = newRow >= 0 && newRow < length && newCol >= 0 && newCol < width;
            if (isValid && grid[newRow][newCol] != 0 && vis[newRow][newCol] == 0) {
                int temp =  calculateGold(newRow, newCol, vis, grid);
                coins = Math.max(coins, temp);
            }
        }
        vis[curRow][curCol] = 0;
        return coins+grid[curRow][curCol];
    }

    public int getMaximumGold(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;

        int maxCoins = 0;
        int vis[][] = new int[length][width];
        for (int startRow = 0; startRow < length; startRow++) {
            for (int startCol = 0; startCol < width; startCol++) {
                if (grid[startRow][startCol] != 0) {
            
                    int temp = calculateGold(startRow, startCol, vis, grid);
                    maxCoins = Math.max(maxCoins, temp);
                }
            }
        }

        return maxCoins;
    }
}