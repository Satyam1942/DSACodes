class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int j=0,i=0;
        int maxElement = Integer.MIN_VALUE;
        int count = 0;
        int add=0;
        int length = nums.length;

        while(j<length)   
        {
            if(maxElement>right)
            {
              i=j;
              add=0;
              maxElement = Integer.MIN_VALUE; 
            }

          
            maxElement = Math.max(maxElement,nums[j]);
            if(nums[j]>=left && nums[j]<=right) add=j-i+1;

            if(left<=maxElement && maxElement<=right) count+=add;

            j++;
        }

        return  count;
    }
}