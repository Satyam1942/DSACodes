class Solution {
    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] findErrorNums(int[] nums) {
        int missingNum = 0;
        int repeatedNum = 0;
        int length = nums.length;

        for (int idx = 0; idx < length; idx++) {

            while (nums[idx] != (idx + 1)) {
                int newIdx = nums[idx] - 1;
                swap(nums, idx, newIdx);
                if (nums[idx] == nums[newIdx]) {
                    repeatedNum = nums[idx];
                    missingNum = idx + 1;
                    break;
                }
            }

        }

        int ans[] = new int[2];
        ans[0] = repeatedNum;
        ans[1] = missingNum;
        return ans;

    }
}