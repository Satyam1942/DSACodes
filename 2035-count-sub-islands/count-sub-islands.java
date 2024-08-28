class Solution {
   int ans =0;
public void dfs(int[][] grid1, int[][] grid2, int i , int j){
    if(i<0|| i>=grid1.length ||j<0|| j>=grid1[0].length || grid2[i][j]==0 ) return;
    if(grid1[i][j]== 0)ans =0;
    grid2[i][j] =0;
    dfs(grid1, grid2, i-1, j);
    dfs(grid1, grid2, i+1, j);
    dfs(grid1, grid2, i, j+1);
    dfs(grid1, grid2, i, j-1);
}



public int countSubIslands(int[][] grid1, int[][] grid2) {
    // problem can be solved using dfs
    int res=0;
    for(int i=0 ;i <grid1.length ;i++){
        for(int j=0 ;j<grid2[0].length ;j++){
            
            if(grid2[i][j]==1)
            {
                ans=1;
                dfs(grid1, grid2, i, j);
                res+=ans;
            }
        }
    }
    return res;
    
}
}