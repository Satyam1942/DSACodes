class Solution {
    int getSum(int [] nums)
    {
        int sum =0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        return sum;
    }
    int getMinimumElement(int nums[])
    {
         int mini = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            mini = Math.min(mini,nums[i]);
        }
        return mini;
    }

    public int minOperations(int[] nums, int x) {
        int sumOfArray = getSum(nums);
        int minElement = getMinimumElement(nums);
        if(x>sumOfArray || x<minElement) return -1;

        int left =0, right = 0;
        int length = nums.length;
        int subArraySum = sumOfArray-x;
        int maxLength = 0 , tempSubarraySum =0;

        while(right<=length)
        {
            if(tempSubarraySum > subArraySum )
            {
                 tempSubarraySum-=nums[left];
                 left++;
                 continue;
            }

            if(tempSubarraySum == subArraySum)
            {
                maxLength = Math.max(maxLength,right-left);
            }

            if(right<length) tempSubarraySum+=nums[right];
            right++;
        }

        return length-maxLength;
    }
}