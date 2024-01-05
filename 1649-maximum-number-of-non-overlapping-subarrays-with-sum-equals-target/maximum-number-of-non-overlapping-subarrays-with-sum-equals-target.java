class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int length = nums.length;
        int count = 0;
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int index = 0; index < length; index++) {
            sum += nums[index];
            int search = sum-target;

            if (set.contains(search) || sum==target ){
                set = new HashSet<>();
                count++;
                sum = 0;
            }  
            set.add(sum);
        }

        return count;

    }
}