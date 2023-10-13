class Solution {
    int rec(int index ,int cost[],  Integer dp[])
    {
        if(index>=cost.length) return 0;
        if(dp[index+1]!=null) return dp[index+1];

        int oneStep =  rec(index+1,cost,dp);
        int twoSteps =  rec(index+2,cost,dp);
        if(index==-1) return dp[0] = Math.min(oneStep,twoSteps);

        return dp[index+1] = cost[index]+ Math.min(oneStep,twoSteps);
    }
    public int minCostClimbingStairs(int[] cost) {
        Integer dp[] = new Integer[cost.length+1];
        return  rec(-1,cost,dp);
    }
}