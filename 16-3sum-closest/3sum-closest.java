class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // nlogn
        Arrays.sort(nums);

        int distance = Integer.MAX_VALUE;
        int closestSum = 0;
        int length = nums.length;
        System.out.println(Arrays.toString(nums));
        // O(n^2)
        for (int i = 0; i < length; i++) {
            int newTarget = target - nums[i];
            int j = i + 1, k = length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                int curDistance = Math.abs(newTarget - sum);
                if (curDistance < distance) {
                    distance = curDistance;
                    closestSum = sum+nums[i];
                }

                if (sum < newTarget)
                    j++;
                else
                    k--;
            }
        }

        return closestSum;

    }
}