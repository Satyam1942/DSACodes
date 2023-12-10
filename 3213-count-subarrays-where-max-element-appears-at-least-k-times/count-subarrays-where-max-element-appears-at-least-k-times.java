class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxi = 0;
        int n = nums.length;
        for(int i=0;i<nums.length;i++)
        {
            maxi = Math.max(maxi,nums[i]);
        }

        int i=0,j=0;
        int countMax = 0;
        long noOfSubArrays= 0;
        while(i<=j && j<=nums.length)
        {
            if(countMax==k)
            {
                noOfSubArrays+= (long)(n-j+1);
                if(nums[i]==maxi) countMax--;
                i++;
                continue;
            }

            if(j<nums.length && nums[j]==maxi) countMax++;
            j++;
        }

        return noOfSubArrays;
    }
}