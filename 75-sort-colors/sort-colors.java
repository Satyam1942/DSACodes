class Solution {
    void swap(int nums[], int left , int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void sortColors(int[] nums) {
        int length = nums.length;
        int left = 0;
        int mid = 0;
        int right = length-1;

        while(mid<=right){
            if(nums[mid]==0){
                swap(nums,left,mid);
                left++;
            }
            if(nums[mid]==2){
                swap(nums,right,mid);
                right--;
            }
            if(nums[mid]==1)
                mid++;
            if(mid<left)
                mid=left;
        }

    }
}
/*          l
            m   r    
   0    0   1   1   2   2
   
    swap  0 of mid with left 
    swap  2 of mid with right
 */