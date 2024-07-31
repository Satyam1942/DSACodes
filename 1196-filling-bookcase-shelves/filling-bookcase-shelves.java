class Solution {
    int rec(int [][] books , int i, int j, int selfWidth,int [][] dp)
    {   
        if(i>j) return 0;
        if(i==j) return books[i][1];
        if(dp[i][j]!=-1) return dp[i][j];

        int width=0,curHeight=0,mini = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++)
        {
            width+=books[k][0];
            curHeight = Math.max(curHeight,books[k][1]);
            if(width>selfWidth) break;

            int height = curHeight+rec(books,k+1,j,selfWidth,dp);
            mini = Math.min(mini,height);
        }
        
        return dp[i][j] = mini;
    }
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int len =books.length;
        int dp[][] = new int[len][len];
        for(int [] row: dp) Arrays.fill(row,-1);
        return rec(books,0,books.length-1,shelfWidth,dp);
    }
}