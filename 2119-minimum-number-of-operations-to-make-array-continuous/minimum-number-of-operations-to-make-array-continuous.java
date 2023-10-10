class Solution {
    public int minOperations(int[] nums) {
      Arrays.sort(nums);
      int len = nums.length;
      int count = len, j=1, dup = 0;
      int dupArr[] = new int[len];
        for(int i=0;i<len;i++)
        {
           for(;j<len && nums[j]<=nums[i]+len-1;j++)
           {
               if(nums[j]==nums[j-1]) dup++;
               dupArr[j] = dup;
           }
            count = Math.min(count, len-(j-i) + dup-dupArr[i]);
        }

        return count;
    }   
}