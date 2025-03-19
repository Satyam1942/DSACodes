class Solution {
    public int minOperations(int[] nums) {
        int length = nums.length;
        int count = 0;
        for(int i=0;i<=length-3;i++){
            if(nums[i]==1)
                continue;
            
            for(int j=i;j<i+3;j++){
                nums[j] = 1-nums[j];
            }
            count++;
        }
        
        
        for(int i=0;i<length;i++)
            if(nums[i]==0)
                return -1;
        
        return count;
    }
}