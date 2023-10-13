class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int oneStep =0 , twoSteps = 0;

        for(int i= cost.length-1;i>=-1;i--)
        {
            int temp = twoSteps;
            twoSteps =  oneStep;
            if(i==-1) oneStep= Math.min(temp,twoSteps);
            else  oneStep = cost[i]+ Math.min(temp,twoSteps);
        }

        return oneStep;
    }
}