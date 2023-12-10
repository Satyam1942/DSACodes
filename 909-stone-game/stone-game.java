class Solution {
    public boolean stoneGame(int[] piles) {
        int n =piles.length;
        int  dp[][] = new int[n+1][n+1];

        int i=0,j=n-1;
        while(i<=j)
        {  
            
            int takeFirst = piles[i]-dp[i+1][j];
            int takeLast =  piles[j-1]-dp[i][j-1];
            dp[i][j] = Math.max(takeFirst,takeLast);
            i++;
            j--;
        }

        return dp[0][piles.length-1]>0;
    }
}