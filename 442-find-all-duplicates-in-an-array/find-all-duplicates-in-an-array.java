class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int length = nums.length;
        List<Integer> duplicates = new ArrayList<>();
        for (int index = 0; index < length; index++) {
            int val = nums[index];
            while (val != (index + 1)) {
                if (val == 0)
                    break;
                else if (val == nums[val - 1]) {
                    nums[index] = 0;
                    duplicates.add(val);
                    break;
                } else {
                    int temp = nums[val - 1];
                    nums[val - 1] = val;
                    nums[index] = temp;
                    val = nums[index];
                }
            }
        }
        return duplicates;

    }
}