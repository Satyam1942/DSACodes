class Solution {
    boolean checkIfDecreasing(int [] nums)
    {
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>nums[i-1]) return false;
        }
        return true;
    }


    boolean checkIfIncreasing(int [] nums)
    {
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<nums[i-1])  return false;
        }
        return true;
    }

    public boolean isMonotonic(int[] nums) {
        int length = nums.length;
        if(nums[length-1]<=nums[0]) return checkIfDecreasing(nums);
        else return checkIfIncreasing(nums);
    }
}