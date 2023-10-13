class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Integer dp[] = new Integer[cost.length+3];

        for(int i= cost.length+1;i>=-1;i--)
        {
            if(i>=cost.length) {dp[i+1] = 0; continue;}
             int oneStep =  dp[i+2];
            int twoSteps =  dp[i+3];

            if(i==-1) dp[0] = Math.min(oneStep,twoSteps);
            else dp[i+1] = cost[i]+ Math.min(oneStep,twoSteps);
        }

        return dp[0];
    }
}