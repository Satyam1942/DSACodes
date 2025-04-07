class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int i:nums)sum+=i;

        if(sum%2!=0) return false;
        int target = sum/2;

        boolean dp[][] = new  boolean[nums.length+1][target+1];
        dp[nums.length][0]=true;

        for(int i=1;i<=target;i++)
        {
            dp[nums.length][i]=false;
        }


        for(int index =nums.length-1;index>=0;index--)
        {
            for(int i=0;i<=target;i++)
            {

            boolean notPick = false, pick = false;
           
            notPick =  dp[index+1][i];

            if(i>=nums[index])
            pick =  dp[index+1][i-nums[index]];

            if(pick|notPick ) dp[index][i] = true;
            else dp[index][i] = false;

            }
        }
      
        return dp[0][target];
    }
}