class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left =0,right=0;
        int len = nums.length;
        int product =1,count=0;

        while(right<=len && left<=right) {
           if(product>=k) {
                product/=nums[left];
                left++;
                continue;
            }   

            if(right<len)
                product*=nums[right];
            count+=(right-left);
            right++;
        }

        return count;
    }
}