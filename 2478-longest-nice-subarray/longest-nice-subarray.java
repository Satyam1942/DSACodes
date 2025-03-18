class Solution {
    public int longestNiceSubarray(int[] nums) {
        int length = nums.length;
        int i = 0, j = 0;
        int mask = 0;
        int longestSubArr = 0;

        while(j<length) {
            int curNum = nums[j];
            boolean canExtend = (mask&curNum)==0;
            if(canExtend) {
                mask|=curNum;
                longestSubArr = Math.max(longestSubArr, j-i+1);
            } else {
                mask^=nums[i];
                i++;
                continue;
            }
            j++;
        }
        return longestSubArr;
    }
}

/*
    
*/