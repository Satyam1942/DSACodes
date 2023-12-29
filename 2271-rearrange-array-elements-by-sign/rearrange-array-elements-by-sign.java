class Solution {
    void swap(int arr[], int ptr1, int ptr2) {
        int temp = arr[ptr1];
        arr[ptr1] = arr[ptr2];
        arr[ptr2] = temp;
    }

    public int[] rearrangeArray(int[] nums) {
        int ptr1 = 0, ptr2 = 0;
        int length = nums.length;
        while (ptr1 < length) {
            if (ptr1 % 2 == 0) {
                // positive check
                if (nums[ptr1] < 0) {
                    ptr2 = ptr1 + 1;
                    while (ptr2 < length && nums[ptr2] < 0)
                     {swap(nums,ptr1,ptr2);   ptr2++;}
                    swap(nums, ptr1, ptr2);
                }
            } else {
                // negative check
                if (nums[ptr1] > 0) {
                    ptr2 = ptr1 + 1;
                    while (ptr2 < length && nums[ptr2] > 0)
                      {swap(nums,ptr1,ptr2);  ptr2++;}
                    swap(nums, ptr1, ptr2);
                }

            }

            ptr1++;

        }

        return nums;

    }
}