class Solution {
    int dfs(int curRow, int curCol, int uniqueId, int idIsland[][], int vis[][], int grid[][]) {
        vis[curRow][curCol] = 1;
        idIsland[curRow][curCol] = uniqueId;
        int deltaRow[] = {-1,0,1,0};
        int deltaCol[] = {0,1,0,-1};
        int size = 0;

        for(int i=0; i<4; i++) {
            int adjRow = curRow + deltaRow[i];
            int adjCol = curCol + deltaCol[i];
            boolean isValid = adjRow>=0 && adjCol>=0 && adjRow<grid.length && adjCol<grid[0].length;
            if(isValid && grid[adjRow][adjCol] ==1 && vis[adjRow][adjCol]==0) {
                size+= dfs(adjRow, adjCol, uniqueId, idIsland, vis, grid);
            }
        }

        return size+1;
    }

    public int largestIsland(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        int idIsland[][] = new int[length][width];
        int vis[][] = new int[length][width];
        int uniqueId = 0;
        int deltaRow[] = {-1,0,1,0};
        int deltaCol[] = {0,1,0,-1};
        HashMap<Integer,Integer> sizeMap = new HashMap<>();

        for(int i=0; i<length; i++) {
            for(int j=0; j<width; j++) {
                if(grid[i][j] ==1 && vis[i][j]==0) {
                    int size = dfs(i, j, uniqueId, idIsland, vis, grid);
                    sizeMap.put(uniqueId, size);
                    uniqueId++;
                }
            }
        }

        int maxSize = 0;
        for(Map.Entry<Integer, Integer> i: sizeMap.entrySet()) {
            maxSize = Math.max(maxSize, i.getValue());
        }

        for(int i=0; i<length; i++) {
            for(int j=0; j<width; j++) {
                if(grid[i][j]==0) {
                    HashSet<Integer> set = new HashSet<>();
                        for(int k=0; k<4; k++) {
                            int adjRow = i + deltaRow[k];
                            int adjCol = j + deltaCol[k];
                            boolean isValid = adjRow>=0 && adjCol>=0 && adjRow<grid.length && adjCol<grid[0].length;
                            if(isValid && grid[adjRow][adjCol]==1) {
                                set.add(idIsland[adjRow][adjCol]);
                            }
                        }
                
                    int size = 1;
                    for(int k : set) {
                        size+= sizeMap.get(k);
                    }
                    maxSize = Math.max(maxSize, size);    
                }
            }
        }

        return maxSize;
    }
}


/*
    1 0 
    0 1

*/