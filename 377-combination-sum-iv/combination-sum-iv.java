class Solution {
    int rec(int nums[], int target,int [] dp)
    {
        if(target==0) return dp[target] = 1;
        if(dp[target]!=-1) return dp[target];

        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
        
        int take=0;
        if(nums[i]<=target) take = rec(nums,target-nums[i],dp);
        ans+=take;
        }

        return dp[target] = ans;
    }
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[1001];
        Arrays.fill(dp,-1);
        return rec(nums,target,dp);
    }
}