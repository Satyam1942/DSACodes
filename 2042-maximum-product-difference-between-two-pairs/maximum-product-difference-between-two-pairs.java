class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int ans = (nums[length-1]*nums[length-2])-(nums[1]*nums[0]);
        return ans;
    }
}