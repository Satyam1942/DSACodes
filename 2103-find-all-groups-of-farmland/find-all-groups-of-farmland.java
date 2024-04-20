class Pair {
    int row, col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    int[] bfs(int row, int col, int vis[][], int land[][]) {
        int length = land.length;
        int width = land[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = 1;

        int delRow[] = { 0, 1, 0, -1 };
        int delCol[] = { 1, 0, -1, 0 };
        int res[] = new int[2];

        while (!q.isEmpty()) {
            int curRow = q.peek().row;
            int curCol = q.peek().col;
            q.poll();
            res[0] = curRow;
            res[1] = curCol;

            for (int i = 0; i < 4; i++) {
                int adjRow = curRow + delRow[i];
                int adjCol = curCol + delCol[i];
                boolean isValid = adjRow >= 0 && adjRow < length && adjCol >= 0
                        && adjCol < width && vis[adjRow][adjCol] == 0 &&
                        land[adjRow][adjCol] == 1;
                if (isValid) {
                    q.add(new Pair(adjRow, adjCol));
                    vis[adjRow][adjCol] = 1;
                }
            }
        }

        return res;
    }

    public int[][] findFarmland(int[][] land) {
        int length = land.length;
        int width = land[0].length;

        int vis[][] = new int[length][width];
        List<int[]> coordinates = new ArrayList<>();

        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {

                if (vis[row][col] == 0 && land[row][col] == 1) {
                    int topLeftRow = row;
                    int topLeftCol = col;
                    int[] bottomRight = bfs(row, col, vis, land);

                    int temp[] = new int[4];
                    temp[0] = topLeftRow;
                    temp[1] = topLeftCol;
                    temp[2] = bottomRight[0];
                    temp[3] = bottomRight[1];

                    coordinates.add(temp);
                }
            }
        }

        int answer[][] = new int[coordinates.size()][4];
        for (int i = 0; i < coordinates.size(); i++) {
            answer[i] = coordinates.get(i);
        }

        return answer;

    }
}