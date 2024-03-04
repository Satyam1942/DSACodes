class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int numberOfNodes = nums.length;
        long sum =0;
        long minLoss =  Integer.MAX_VALUE;
        int count = 0;
        for(int i=0;i<numberOfNodes;i++){
            if(nums[i]<(nums[i]^k)){
                sum+=(nums[i]^k);
                minLoss = Math.min(minLoss,(nums[i]^k)-nums[i]);
                count++;
            }else{
                sum+=nums[i];
                minLoss = Math.min(minLoss,nums[i]-(nums[i]^k));
            }
        }

        if(count%2==0)
            return sum;
        else 
            return sum-minLoss;
    }
}
/*
[2,2,2,3]
[[0,1],[0,2],[2,3]]
[2,]

001
011
010
 */