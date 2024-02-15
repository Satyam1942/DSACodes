class Solution {
    public long largestPerimeter(int[] nums) {
            Arrays.sort(nums);
            long sum = 0;
        long prefixSum[] = new long[nums.length];
        
        prefixSum[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
           prefixSum[i]=nums[i]+prefixSum[i-1];     
        }
        
        for(int i=nums.length-1;i>=2;i--)
        {
            if(prefixSum[i]-nums[i]>nums[i]) return prefixSum[i];
        }
        
        return -1;
    }
}

/*
    1,1,2,3,5,12,50
    1,2,4,7,12,24,74
    
*/