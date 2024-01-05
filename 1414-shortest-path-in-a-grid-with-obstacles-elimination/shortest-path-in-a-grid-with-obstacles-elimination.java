class Tuple {
    int row, col, k,dist;

    Tuple(int row, int col, int k,int dist) {
        this.row = row;
        this.col = col;
        this.k = k;
        this.dist = dist;
    }
}

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int length = grid.length;
        int width = grid[0].length;

        Queue<Tuple> q = new LinkedList<>();
        int step[][][] = new int[length][width][k+1];
        
        for (int[][] dist : step) 
            for (int[] d : dist)
                Arrays.fill(d, Integer.MAX_VALUE);

        Arrays.fill(step[0][0], 0);

        q.add(new Tuple(0, 0, k,0));

        int delRow[] = { -1, 0, 1, 0 };
        int delCol[] = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int curRow = q.peek().row;
            int curCol = q.peek().col;
            int noOfObstacleEliminate = q.peek().k;
            int curStep = q.peek().dist;

            q.poll();
         
            for (int i = 0; i < 4; i++) {
                int newRow = delRow[i] + curRow;
                int newCol = delCol[i] + curCol;
                boolean isValid = newRow >= 0 && newCol >= 0
                        && newRow < length && newCol < width;

                if (isValid) {
                    int newEliminate= noOfObstacleEliminate-grid[newRow][newCol];
                    if (newEliminate>=0 && step[newRow][newCol][newEliminate]> curStep + 1) {
                        q.add(new Tuple(newRow, newCol,newEliminate,curStep+1 ));
                        step[newRow][newCol][newEliminate] = curStep + 1;
                    }
                }

            }
        }

       
        int shortestPathLength= Integer.MAX_VALUE;
        for(int  i=0;i<=k;i++)
            shortestPathLength=Math.min(shortestPathLength,step[length - 1][width - 1][i]);
    
        if (shortestPathLength == Integer.MAX_VALUE) return -1;
        else return shortestPathLength;
    }
}