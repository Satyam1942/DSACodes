class Solution {
    public boolean check(int[] nums) {
        int length = nums.length;
        boolean pivot = false;
        for(int i=0;i<length-1;i++) {
            if(nums[i]>nums[i+1]) {
                if(pivot) {
                    return false;
                } 
                pivot = true;
            }
        }

        if(pivot) {
            if(nums[0]<nums[length-1]) {
                return false;
            }
        }
        
        return true;
    }
}