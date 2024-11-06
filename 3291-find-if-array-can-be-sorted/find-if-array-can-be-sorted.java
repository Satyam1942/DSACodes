class Solution {
    int checkNoOfSetBits(int num){
        int noOfSetBits = 0;
        for(int i=0;i<32;i++){
            if((num&(1<<i))!=0)
               noOfSetBits++;
        }
        
        return noOfSetBits;
    }
    
    public boolean canSortArray(int[] nums) {
        if(nums.length == 1) {
            return true;
        }

        int currentMin = nums[0], currentMax = nums[0],  previousMax = Integer.MIN_VALUE;
        int prevBitCount = checkNoOfSetBits(nums[0]);

        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            int curBitCount = checkNoOfSetBits(num);
            if(curBitCount == prevBitCount) {
                currentMin = Math.min(currentMin, num);
                currentMax = Math.max(currentMax, num);
            } else {
                if(previousMax>currentMin) {
                    return false;
                }
                prevBitCount = curBitCount;
                previousMax = currentMax;
                currentMin = nums[i];
                currentMax = nums[i];
            }
        }
        System.out.println(currentMin+" "+previousMax);
        return currentMin>=previousMax;
    }
}