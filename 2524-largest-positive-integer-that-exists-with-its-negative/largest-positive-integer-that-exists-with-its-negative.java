class Solution {
    public int findMaxK(int[] nums) {
        int length = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int maxNumber = -1;
        for (int i = 0; i < length; i++) {
            if (set.contains(-nums[i])) {
                maxNumber = Math.max(maxNumber, Math.abs(nums[i]));
            }
            set.add(nums[i]);

        }
        return maxNumber;
    }
}