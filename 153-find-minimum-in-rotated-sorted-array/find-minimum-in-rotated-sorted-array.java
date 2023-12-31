class Solution {
    public int findMin(int[] nums) {
        int start =0;
        int end = nums.length-1;
        int minVal = nums[0];
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(nums[mid]<nums[start]) {end = mid-1; minVal = Math.min(nums[mid-1],nums[mid]);}
            else if(nums[mid]>nums[end]){start = mid+1; minVal = Math.min(nums[mid+1],nums[mid]);}
            else break;
        }
        return minVal;
    }
}