class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int numberOfNodes = nums.length;
        long sum = 0;
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
The catch in this question is you can propagate xor between any  2 nodes as its a tree.
Thats the only use of tree in this question.
You can clearly see I havent used any edges of tree in this
If pair  of nodes for which taking xor increases the value we will do that and it will return 
maximum sum
else if it is odd I will find the minimumLoss that I can have by taking / not taking xor of one
 node 
 */