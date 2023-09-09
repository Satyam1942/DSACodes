class Solution {
    int rec(int n, int floor, int dp[])
    {
        if(floor>n) return Integer.MIN_VALUE;

        if(dp[floor] !=-1 ) return dp[floor];

        int mini = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++)
        {
            int moves = 1+Math.max(i-1,rec(n,floor+i,dp));
            mini = Math.min(moves,mini);
        }

        return dp[floor] = mini;
    }
    public int twoEggDrop(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return rec(n,1,dp);
    }
}