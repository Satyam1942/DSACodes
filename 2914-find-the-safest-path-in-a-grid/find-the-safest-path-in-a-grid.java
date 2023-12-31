class Pair {
    int row, col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

}

class Solution {
    void distanceFromAllThieves(int grid[][], int distFromThief[][]) {
        int length = grid.length;
        int width = grid[0].length;

        for (int row[] : distFromThief)
            Arrays.fill(row, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();

        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == 1) {
                    q.add(new Pair(row, col));
                    distFromThief[row][col] = 0;
                }
            }
        }

        int delRow[] = { 0, 1, 0, -1 };
        int delCol[] = { 1, 0, -1, 0 };
        while (!q.isEmpty()) {
            int curRow = q.peek().row;
            int curCol = q.peek().col;
            int curDist = distFromThief[curRow][curCol];
            q.poll();
            for (int i = 0; i < 4; i++) {
                int adjRow = curRow + delRow[i];
                int adjCol = curCol + delCol[i];
                boolean isValid = adjRow >= 0 && adjCol >= 0 &&
                        adjRow < length && adjCol < width;

                if (isValid && curDist + 1 < distFromThief[adjRow][adjCol]) {
                    distFromThief[adjRow][adjCol] = curDist+ 1;
                    q.add(new Pair(adjRow, adjCol));
                }
            }
        }
    }

    void safestPathInGrid(int distFromThief[][], int safeness[][]) {
        int length = distFromThief.length;
        int width = distFromThief[0].length;
      	for(int row[]: safeness) Arrays.fill(row,Integer.MIN_VALUE);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        safeness[0][0] = distFromThief[0][0];

        int delRow[] = { 0, 1, 0, -1 };
        int delCol[] = { 1, 0, -1, 0 };
        while (!q.isEmpty()) {
            int curRow = q.peek().row;
            int curCol = q.peek().col;
            int curSafeness = safeness[curRow][curCol];
            q.poll();
            for (int i = 0; i < 4; i++) {
                int adjRow = curRow + delRow[i];
                int adjCol = curCol + delCol[i];
                boolean isValid = adjRow >= 0 && adjCol >= 0 &&
                        adjRow < length && adjCol < width;

                if (isValid ) {
                    int adjSafeness = distFromThief[adjRow][adjCol];
                    if(safeness[adjRow][adjCol]<Math.min(curSafeness,adjSafeness))
			        {
					safeness[adjRow][adjCol] = Math.min(curSafeness,adjSafeness);
					q.add(new Pair(adjRow,adjCol));
                    }
                }
            }
        }

    }


    public int maximumSafenessFactor(List<List<Integer>> matrix) {

        int grid[][] = new int[matrix.size()][matrix.size()];
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                grid[i][j] = matrix.get(i).get(j);
            }
        }

        int length = grid.length;
        int width = grid[0].length;
        int distFromThief[][] = new int[length][width];
        int safeness[][] = new int[length][width];

        distanceFromAllThieves(grid, distFromThief);
        safestPathInGrid(distFromThief, safeness);
       

        int maxmSafeDist = safeness[length - 1][width - 1];
        return maxmSafeDist;

    }
}