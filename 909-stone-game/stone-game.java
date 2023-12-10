class Solution {
    int  rec(int i, int j, int[] piles,  Integer dp[][])
    {
        if(i>j)  return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int takeFirst = piles[i]- rec(i+1,j,piles,dp);
        int takeLast =  piles[j]- rec(i,j-1,piles,dp);
        return dp[i][j] = Math.max(takeFirst,takeLast);
       
    }

    public boolean stoneGame(int[] piles) {
        int n =piles.length;
        Integer dp[][] = new Integer[n][n];
        return rec(0,piles.length-1,piles,dp)>0;
    }
}