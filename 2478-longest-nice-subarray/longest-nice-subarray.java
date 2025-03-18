class Solution {

    boolean isPossible(int bit[], int num) {
        for(int i=0; i<32; i++) {
            boolean isCurBitSet = (num&(1<<i))>0;
            if(isCurBitSet) {
                if(bit[i]==1) {
                    return false;
                }
            }
        }
        return true;
    }

    void setBitArr(int bit[], int num) {
        for(int i=0; i<32; i++) {
            boolean isCurBitSet = (num&(1<<i))>0;
            if(isCurBitSet) {
               bit[i] = 1;
            }
        }
    }

    void resetBitArr(int [] bit, int num) {
        for(int i=0; i<32; i++) {
            boolean isCurBitSet = (num&(1<<i))>0;
            if(isCurBitSet) {
               bit[i] = 0;
            }
        }
    }

    public int longestNiceSubarray(int[] nums) {
        int length = nums.length;
        int i = 0, j = 0;
        int bit[] = new int[32];
        int longestSubArr = 0;

        while(j<length) {
            int curNum = nums[j];
            boolean canExtend = isPossible(bit, curNum);
            if(canExtend) {
                setBitArr(bit, curNum);
                longestSubArr = Math.max(longestSubArr, j-i+1);
            } else {
                resetBitArr(bit, nums[i]);
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