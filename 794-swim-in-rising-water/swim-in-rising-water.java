class Pair {
    int row, col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int length = grid.length;
        int time[][] = new int[length][length];

        for (int row[] : time)
            Arrays.fill(row, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        time[0][0] = grid[0][0];

        int delRow[] = { 0, 1, 0, -1 };
        int delCol[] = { -1, 0, 1, 0 };

        // BFS algorithm
        while (!q.isEmpty()) {
            int curRow = q.peek().row;
            int curCol = q.peek().col;
            int curMaxElevation = time[curRow][curCol];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int newRow = curRow + delRow[i];
                int newCol = curCol + delCol[i];
                boolean isValidCoordinate = newRow >= 0 && newRow < length &&
                        newCol >= 0 && newCol < length;

                if (isValidCoordinate) {
                    int newElevation = Math.max(curMaxElevation, grid[newRow][newCol]);

                    if (time[newRow][newCol] > newElevation) {
                        time[newRow][newCol] = newElevation;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }

        }

        return time[length - 1][length - 1];

    }
}