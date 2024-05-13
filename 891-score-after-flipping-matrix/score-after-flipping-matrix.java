class Solution {
    void swapRowWise(int grid[][]) {
        int length = grid.length;
        int width = grid[0].length;
        for (int i = 0; i < length; i++) {
            if (grid[i][0] == 1)
                continue;
            for (int j = 0; j < width; j++) {
                grid[i][j] = 1 - grid[i][j];
            }
        }
    }

    void calculateFrequencyOfOne(int grid[][], int frequency[]) {
        int noOfRows = grid.length;
        int noOfCols = grid[0].length;
        for (int col = 0; col < noOfCols; col++) {
            for (int row = 0; row < noOfRows; row++) {
                if (grid[row][col] == 1)
                    frequency[col]++;
            }
        }
    }

    void swapColumnWise(int grid[][], int frequency[]) {
        int noOfRows = grid.length;
        int noOfCols = grid[0].length;
        for (int col = 0; col < noOfCols; col++) {
            if (frequency[col] > noOfRows / 2)
                continue;
            for (int row = 0; row < noOfRows; row++) {
                grid[row][col] = 1 - grid[row][col];
            }
        }
    }

    public int matrixScore(int[][] grid) {
        int noOfRows = grid.length;
        int noOfCols = grid[0].length;
        int frequencyOneColumn[] = new int[noOfCols];

        swapRowWise(grid);
        calculateFrequencyOfOne(grid, frequencyOneColumn);
        swapColumnWise(grid, frequencyOneColumn);

        int sum = 0;
        for (int row = 0; row < noOfRows; row++) {

            int number = 0;
            for (int col = noOfCols - 1; col >= 0; col--) {
                if (grid[row][col] == 1)
                    number = number ^ (1 << (noOfCols - 1 - col));
            }
            sum += number;
        }

        return sum;

    }
}