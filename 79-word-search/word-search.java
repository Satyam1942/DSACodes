class Solution {
    boolean dfs(int vis[][],char[][] board, int row, int col, int m, int n,String word,int index)
    {
        if(index==word.length()-1) 
        {
         if(word.charAt(index) != board[row][col]) return false;
         else return true;
        }

        if(word.charAt(index) != board[row][col]) return false;
        vis[row][col]=1;
        int delRow[] = {-1,1,0,0};
        int delCol[] = {0,0,1,-1};
        for(int i=0;i<4;i++)
        {
            int newRow = row+delRow[i];
            int newCol = col+delCol[i];
            if(newRow>=0 && newCol>=0 && newCol<n && newRow<m && vis[newRow][newCol]==0)
            {
               boolean res =  dfs(vis, board, newRow, newCol,m,n,word,index+1);
               if(res) return res;
            }
        }

        vis[row][col] = 0;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int vis[][] = new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(word.charAt(0)==board[i][j])
                {
                    boolean res = dfs(vis,board,i,j,m,n,word,0);
                    if(res) 
                        return true;
                }
            }
        }
        return false;
    }
}

/*
    FOLLOW UP VIA PRUNING SEARCH!! (REMOVING unnessary things!!)

    1.count frequency of all characters in string as well as board. If any character is mismatching
    or any character is not present , we can simply return false

    2. If first letters are present more in board than last letter we will search from end of thw word
    instead of starting

    This makes time complexity same but removes many irrelevant cases!!
 */