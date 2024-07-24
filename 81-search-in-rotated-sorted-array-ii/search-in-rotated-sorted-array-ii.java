class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(target==nums[mid])
                return true;

            if(target<nums[mid]) {
               if(target>=nums[left])
                    right = mid-1;
                else
                    left++;
            }
            else if(target>nums[mid]) {
                 if(target<=nums[right])
                    left = mid+1;
                else
                    right--;
            }
        }

        return false;
    }
}