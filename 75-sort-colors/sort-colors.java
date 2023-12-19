class Solution {
    void swap(int nums[] ,int a, int b)
    {
        int temp = nums[a];
        nums[a]= nums[b];
        nums[b]= temp;
    }

    public void sortColors(int[] nums) {
        int left =0,mid= 0, right = nums.length-1;
        
        while(mid<=right)
        {
            if(nums[mid]==0)
            {
                swap(nums,left,mid);
                left++;
            }
            else if(nums[mid]==2)
            {
                swap(nums,right,mid);
                right--;
            }
            else mid++;

            if(left>mid) mid= left;
            
        }

    }
}

/*
    [0,0,1,1,2,2]
 */