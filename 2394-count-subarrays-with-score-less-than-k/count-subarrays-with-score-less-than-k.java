class Solution {
    public long countSubarrays(int[] nums, long k) {
        int i=0,j=0;
        long curSum = 0l;
        long count = 0l;
        while(i<=j && j<=nums.length)
        {
            if(curSum*(j-i)>=k)
            {
                curSum-=nums[i];
                i++;
                continue;
            }else count+=(long)(j-i);

            if(j<nums.length)
            curSum+=nums[j];
            
            j++;
        }

        return count;
    }
}