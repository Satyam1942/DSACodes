class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target)
                return mid;
           
            if(nums[mid]>nums[right]){
                if(target>nums[mid])
                    left = mid+1;
                else {
                    if(target<nums[left])
                        left = mid+1;
                    else
                        right = mid-1;
                }
           }else{
                if(target>nums[mid]){
                    if(target<=nums[right])
                        left = mid+1;
                    else
                        right = mid-1;
                }else{
                    right = mid-1;
                }
           }
        }

        return -1;
    }
}
/*
    [...,5,6,7,8,0,1,2]
 */