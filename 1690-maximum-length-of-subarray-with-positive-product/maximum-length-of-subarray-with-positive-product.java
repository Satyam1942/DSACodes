class Solution {
    public int getMaxLen(int[] nums) {
        int left =0,right=0,negativeCount=0;
        boolean isPositive = true;
        int maxi = 0,len = nums.length;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)negativeCount++;
        }

        while(right<len)
        {
            if(nums[right]<0)
            {
                negativeCount--;
                isPositive = !isPositive;

                if(!isPositive && negativeCount == 0) {
                   while(nums[left]>0)
                   {
                       left++;
                   }
                   left++;
                   isPositive = true;
                }
            }
            else if(nums[right]==0)
            {
                if(!isPositive)
                 {
                    while(nums[left]>0)
                   {
                       left++;
                   }
                   left++;
                   maxi = Math.max(maxi,right-left);
                 }

                left = right+1;
                right++;
                isPositive = true;
                continue;
            }

            if(isPositive) maxi = Math.max(maxi,right-left+1);
            right++;
        }

        return maxi;
    }
}