class Solution {
    int recursion(int index, int curBitOr, int maxBitOr, int nums[], Integer cache[][]) {
        if(index == nums.length) {
            if(curBitOr==maxBitOr) {
                return 1;
            } else {
                return 0;
            }
        }

        if(cache[index][curBitOr]!=null) {
            return cache[index][curBitOr];
        }

        int notTakeOr = recursion(index+1, curBitOr, maxBitOr, nums, cache);
        int takeOr = recursion(index+1, curBitOr|nums[index], maxBitOr, nums, cache);

        return cache[index][curBitOr] = takeOr+notTakeOr;
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxBitOr = 0;
        int length = nums.length;

        for(int i = 0;i<length;i++) {
            maxBitOr |= nums[i]; 
        }
        
        Integer cache[][] = new Integer[length+1][maxBitOr+1];
        return recursion(0, 0, maxBitOr, nums, cache);
    }
}