class Solution {

    int rec(int n,int dp[])
    {
        if(n<=1) return 1;
       if(dp[n]!=-1) return dp[n];

        int total=0;
        for(int i=1;i<=n;i++)
        {
            total+= rec(i-1,dp)*rec(n-i,dp);
        }
        return dp[n] = total;
    }
    public int numTrees(int n) {
       
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        return rec(n,dp);

    }
}