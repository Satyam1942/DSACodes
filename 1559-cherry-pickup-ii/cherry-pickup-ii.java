class Solution {
    int getMaximumCherries(int curRow, int colRobo1, int colRobo2, int grid[][],
            Integer cache[][][]) {

        if (curRow == grid.length)
            return 0;

        if (cache[curRow][colRobo1][colRobo2] != null)
            return cache[curRow][colRobo1][colRobo2];

        int noOfCherries = 0;

        if (colRobo1 == colRobo2)
            noOfCherries = grid[curRow][colRobo1];
        else
            noOfCherries = grid[curRow][colRobo1] + grid[curRow][colRobo2];

        int delColRobo1[] = { -1, 0, 1 };
        int delColRobo2[] = { -1, 0, 1 };

        int noOfColumns = grid[0].length;
        int maxCherries = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nextColRobo1 = colRobo1 + delColRobo1[i];
                int nextColRobo2 = colRobo2 + delColRobo2[j];
                boolean isValid = nextColRobo1 >= 0 && nextColRobo1 < noOfColumns && nextColRobo2 >= 0
                        && nextColRobo2 < noOfColumns;
                if (!isValid)
                    continue;

                int temp = getMaximumCherries(curRow + 1,
                        nextColRobo1, nextColRobo2, grid,cache);
                maxCherries = Math.max(maxCherries, temp);
            }
        }

        return cache[curRow][colRobo1][colRobo2] = maxCherries + noOfCherries;
    }

    public int cherryPickup(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        Integer cache[][][]= new Integer[length][width][width];
        return getMaximumCherries(0,0,width-1,grid,cache);
    }
}