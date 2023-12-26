class Solution {
    long mod = (long)(1e9+7);

    long rec(int n, int k, int target ,Long dp[][])
    {
       if(target==0 && n==0) return 1l;
       if(target<0 || n==0) return  0l;
    
       if(dp[n][target]!=null) return dp[n][target];
    
       long ways = 0l;

        for(int i=1;i<=k;i++)
        {
            if(target>=i) ways=(ways+rec(n-1,k,target-i,dp))%mod;
        }

        return dp[n][target]=  ways;
    }
    public int numRollsToTarget(int n, int k, int target) {
        Long dp[][] =new Long[n+1][target+1];

        return (int)rec(n,k,target,dp);
    }
}