class Solution {
    int getUpperBound(int nums[], int key, int index) {
        int left = index;
        int right = nums.length - 1;
        int upperBound = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > key) {
                right = mid - 1;
                upperBound = mid;
            } else
                left = mid + 1;
        }

        return upperBound;
    }

    int getLowerBound(int nums[], int key, int index) {
        int left = index;
        int right = nums.length - 1;
        int lowerBound = left;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < key) {
                left = mid + 1;
                lowerBound = mid;
            } else
                right = mid - 1;
        }

        return lowerBound;
    }

    int maximumPoints(int index, int nums[], Integer cache[]) {
        if (index == nums.length)
            return 0;

        if (cache[index] != null)
            return cache[index];

        int notTake = maximumPoints(index + 1, nums, cache);

        int ceilIndex = getUpperBound(nums, nums[index] + 1, index);
        int floorIndex = getLowerBound(nums, nums[index] + 1, index);

        int score = nums[index] * (floorIndex - index + 1);
        int take = score + maximumPoints(ceilIndex, nums, cache);

        return cache[index] = Math.max(take, notTake);
    }

    public int deleteAndEarn(int[] nums) {

        int length = nums.length;
        Arrays.sort(nums);

        Integer cache[] = new Integer[length];
        return maximumPoints(0, nums, cache);

    }
}