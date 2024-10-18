class Solution {
    int recursion(int index, int curBitOr, int maxBitOr, int nums[]) {
        if(index == nums.length) {
            if(curBitOr==maxBitOr) {
                return 1;
            } else {
                return 0;
            }
        }

        int notTakeOr = recursion(index+1, curBitOr, maxBitOr, nums);
        int takeOr = recursion(index+1, curBitOr|nums[index], maxBitOr, nums);

        return takeOr+notTakeOr;
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxBitOr = 0;
        int length = nums.length;

        for(int i = 0;i<length;i++) {
            maxBitOr |= nums[i]; 
        }

        return recursion(0, 0, maxBitOr, nums);
    }
}