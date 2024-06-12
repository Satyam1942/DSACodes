class Solution {
    void swap(int nums[], int left , int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void sortColors(int[] nums) {
        int left = 0;
        int right = 1;
        int length = nums.length;

        while(right<=length){
            while(left<length && nums[left]==0)
                left++;
            if(left==length)
                break;
            
            right = Math.max(right,left+1);
            if(right<length && nums[right]==0){
                swap(nums,left,right);
            }
            right++;
        }
    
        right = left+1;
        while(right<=length){
            while(left<length && nums[left]==1){
                left++;
            }
            if(left==length)
                break;
            right = Math.max(right,left+1);
            if(right<length && nums[right]==1){
                swap(nums,left,right);
            }
            right++;
        }

    }
}
/*
                   r
    0, 0, 2, 1, 1, 2
          l
 */