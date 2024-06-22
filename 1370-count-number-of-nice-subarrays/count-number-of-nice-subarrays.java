class Solution {
    public int atMostK(int[]nums, int k){
        int length = nums.length;
        int left = 0;
        int right = 0;
        int  count = 0;
        int oddCount = 0;

        while(left<=right && right<=length){

            if(oddCount>k){
                if(nums[left]%2!=0)
                    oddCount--;
                left++;
                continue;
            }
            
            count+=right-left;
            
            if(right<length && nums[right]%2!=0)
                oddCount++;
                
            right++;
        }

        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
       return atMostK(nums,k)-atMostK(nums,k-1);
    }
}

/*
    14-
*/