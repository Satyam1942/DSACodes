class Solution {
    void swap(int [] arr, int a , int b)
    {
        int temp = arr[a];
        arr[a]= arr[b];
        arr[b] = temp;
    }

    public void sortColors(int[] nums) {
        int n  = nums.length;
        int left = 0, right =n-1, mid=0;
        while(mid<=right && mid>=left)
        {
            if(nums[mid]==2)
            {
                swap(nums,mid,right);
                right--;
                continue;
            }
            if(nums[mid]==0)
            {
                swap(nums,left,mid);
                left++;
                mid++;
                continue;
            }
            mid++;
        }
        
    }



}