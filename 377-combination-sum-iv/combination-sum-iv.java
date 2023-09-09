class Solution {
    
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target+1];
        dp[0]=1;
        

        for(int j = 1;j<=target;j++)
        {
            int ans=0;
            for(int i=0;i<nums.length;i++)
            {
        
            int take=0;
            if(nums[i]<=j) take = dp[j-nums[i]];
            ans+=take;
            }

            dp[j] = ans;
        }

        return dp[target];


    }
}