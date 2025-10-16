class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<length; i++) {
            sum+=nums[i];
            maxSum = Math.max(maxSum, sum);
            if(sum<0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}