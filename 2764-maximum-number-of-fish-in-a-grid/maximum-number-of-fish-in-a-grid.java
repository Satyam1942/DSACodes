class Solution {
    
    
    void dfs(int [][] grid, int[][] vis,int [] sum, int nodex ,int nodey, int m ,int n)
    {
        vis[nodex][nodey]= 1;
        sum[0]+= grid[nodex][nodey];
        int delrow[] ={-1,0,1,0};
        int delcol [] = {0,1,0,-1};
        
        for(int i=0;i<4;i++)
        {
            int newrow = nodex+delrow[i];
            int newcol = nodey+delcol[i];
            if(newrow>=0 && newcol>=0 && newrow<m && newcol<n)
            {
                if(grid[newrow][newcol]>0 && vis[newrow][newcol]==0) dfs(grid,vis,sum,newrow,newcol,m,n); 
            }
        }
        
    }
        
    public int findMaxFish(int[][] grid) {
       int m  = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        int maxi =0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int sum[] = new int[1];                
                if(vis[i][j]==0 && grid[i][j]!=0)
                    dfs(grid,vis,sum,i,j,m,n);
                maxi =Math.max(maxi,sum[0]);
            }
        }
        
        return maxi;
    }
}