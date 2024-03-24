class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int fast = 0,slow=0,q =0;
        while(true)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(fast==slow) break;
        }
       
        while(q!=slow)
        {
            q = nums[q];
            slow = nums[slow];
        }

        return q;
    }
}
