class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length==1 || nums.length==2) return 0;
        int i =0,j=1,k=2;
        int count = 0;
        int dif = nums[j]-nums[i];
        int prev = nums[j];

        while(k<nums.length)
        {
            if(nums[k]-prev!=dif)
            {
                j=k;
                dif = nums[k]-prev;
                prev = nums[j];
            }
            else
            {
                count+= k-j;
                prev = nums[k];
            }
            k++;
        }
        return count;
    }
}