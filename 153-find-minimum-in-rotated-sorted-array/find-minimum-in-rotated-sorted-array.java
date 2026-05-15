class Solution {
    public int findMin(int[] nums) {
       int length = nums.length;
       int left = 0;
       int right = length-1;
       while(left<right) {
        int mid = (left+right)/2;
        if(nums[left]>nums[right]) {
            if(nums[mid]>=nums[left]) {
                left = mid+1;
            } else {
                right = mid;
            }
        } else {
           return nums[left];
        }
       } 
       return nums[left];
    }
}