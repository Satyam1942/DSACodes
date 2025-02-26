class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int positiveSum = 0;
        int negativeSum = 0;
        int maxSum = 0;
        int length = nums.length;

        for(int i=0; i<length; i++) {
            int number = nums[i];
            positiveSum+=nums[i];
            negativeSum+=nums[i];
            if(positiveSum<0) {
                positiveSum = 0;
            } 
            if(negativeSum>0) {
                negativeSum = 0;
            }
            maxSum = Math.max(maxSum, Math.max(positiveSum,Math.abs(negativeSum)));
        }

        return maxSum;
    }
}

/*
    2, -5, 1, -4, 3, -2
    2                -7
    maxSum = 8
    curSum = -7
*/