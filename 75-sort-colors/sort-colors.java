class Solution {
    void swap(int i, int j, int nums[]) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        int length = nums.length;
        int start = 0;
        int mid = length-1;
        int end = length-1;
        while(start<=mid) {
            int valStart = nums[start];
            int valMid = nums[mid];
            int valEnd = nums[end];

            if(valMid == 0) {
                swap(start, mid, nums);
            }
            if(valMid == 2) {
                swap(end, mid,nums);
            }

            if(valMid == 1) {
                mid--;
            }

            if(valStart == 0) {
                start++;
            }
            if(valEnd == 2) {
                if(mid==end) {
                    mid--;
                }
                end--;
            }
        }
    }
}