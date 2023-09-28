class Solution {
    void swap(int arr[], int a ,int b)
    {
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public int[] sortArrayByParity(int[] nums) {
        int left =0,right =0;
        while(right<nums.length)
        {
            if(nums[right]%2==0) {swap(nums,left,right); left++;}
            right++;
        }
        return nums;
    }
}