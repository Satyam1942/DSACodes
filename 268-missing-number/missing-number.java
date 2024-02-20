class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sumTheoritical = length*(length+1)/2;
        int sumActual = 0;
        for(int i:nums)
            sumActual+=i;
        return sumTheoritical-sumActual;
    }
}