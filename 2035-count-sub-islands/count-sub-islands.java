class Solution {
    boolean isSubIsland = true;
    
    void dfs(int curRow, int curCol, int vis[][], int grid1[][] , int grid2[][]){
        vis[curRow][curCol]  = 1;
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        int length = grid1.length;
        int width = grid1[0].length;

        for(int i=0;i<4;i++) {
            int adjRow = curRow + delRow[i];
            int adjCol = curCol + delCol[i];
            boolean isValid = adjRow>=0 && adjRow<length && adjCol>=0 && adjCol<width;
            if(isValid && vis[adjRow][adjCol]==0 && grid2[adjRow][adjCol]==1){
                dfs(adjRow,adjCol,vis,grid1,grid2);
                if(grid1[adjRow][adjCol]==0)
                    isSubIsland = false;
            }
        }
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int length = grid1.length;
        int width = grid1[0].length;
        int vis[][] = new int[length][width];

        int count = 0;
        for(int i=0;i<length;i++){
            for(int j=0;j<width;j++){
                if(vis[i][j]==0 && grid2[i][j]==1 && grid1[i][j]==1){
                    isSubIsland = true;
                    dfs(i,j,vis,grid1,grid2);
                    if(isSubIsland)
                        count++;
                }
            }
        }

        return count;
    }
}