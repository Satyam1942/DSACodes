class Solution {
    final int mod = (int)(1e9+7);
    int rec(int curIndex, int steps, int arrLen, Integer dp[][])
    {
        if(steps==0)
        {
            if(curIndex==0) return 1;
            else return 0;
        }
        if(dp[curIndex][steps]!=null) return dp[curIndex][steps];

        if(curIndex==0) 
        {
            int same =  rec(curIndex,steps-1,arrLen,dp)%mod;
            int next =  rec(curIndex+1,steps-1,arrLen,dp)%mod;
            return dp[curIndex][steps] = (int)(((long)same+(long)next)%mod);
        }
        else if(curIndex==arrLen-1)
        {
            int same =  rec(curIndex,steps-1,arrLen,dp)%mod;
            int prev =  rec(curIndex-1,steps-1,arrLen,dp)%mod;
            return dp[curIndex][steps] = (int) (((long)same + (long)prev)%mod);
        }
        else
        {
            int same = rec(curIndex,steps-1,arrLen,dp)%mod;
            int prev = rec(curIndex-1,steps-1,arrLen,dp)%mod;
            int next = rec(curIndex+1,steps-1,arrLen,dp)%mod;
            return dp[curIndex][steps] = (int)(((long)same+(long)prev+(long)next)%mod);
        }


    }
    public int numWays(int steps, int arrLen) {
        if(arrLen==1) return 1;
        Integer dp[][] = new Integer[Math.min(arrLen,steps+1)][steps+1];
        return rec(0,steps,arrLen,dp)%mod;
    }
}