class Solution {
    public int singleNonDuplicate(int[] nums) {
        int length = nums.length;
        int left =0, right = length-1;
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(mid+1<length && nums[mid]==nums[mid+1])
            {
                if((length-mid)%2==0)right = mid-1;
                else left = mid+2;
            }
            else if(mid-1>=0 && nums[mid]==nums[mid-1])
            {
                if((length-(mid-1))%2==0)right =mid-2;
                else left = mid+1; 
            }
            else return nums[mid];
        }

        return -1;
    }
}