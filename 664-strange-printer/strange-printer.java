class Solution {
    int rec(int i,int j ,String s,Integer dp[][])
    {
        
        if(i==j) return 1;
        if(dp[i][j]!=null) return dp[i][j];
        int minTurns = Integer.MAX_VALUE;
    
        for(int k=i;k<j;k++)
        {
            int temp = rec(i,k,s,dp)+rec(k+1,j,s,dp);
            minTurns = Math.min(minTurns,temp);
        }
        
        if(s.charAt(i)==s.charAt(j)) minTurns-=1;
        return dp[i][j] = minTurns;
    }

    public int strangePrinter(String s) {
        Integer dp[][] = new Integer[s.length()][s.length()];
        return rec(0,s.length()-1,s,dp);
    }
}