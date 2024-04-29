class Solution {
    public int minOperations(int[] nums, int k) {
        int bits[]  = new int[32];
        for(int i=0;i<nums.length;i++)
        {
            int num = nums[i];
            for(int j=0;j<32;j++)
            {
                if((num&(1<<j))>0)bits[j]++;
            }
        }
        
        int count = 0;
        for(int i=0;i<32;i++)
        {
            boolean isBitSet = ((k&(1<<i))>0);
            if(isBitSet)
            {
                if(bits[i]%2==0) count++;
            }
            else
            {
                if(bits[i]%2!=0) count++;
            }
        }
        
        
        return count;
    }
}