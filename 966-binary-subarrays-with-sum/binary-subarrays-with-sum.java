class Solution {
    int noOfSubarraysGreaterThan(int nums[], int target) {
        int length = nums.length;
        int left = 0, right = 0;
        int count = 0,sum = 0;

        while (left <= right && right <= length) {
            if (sum > target) {
                count += length - right + 1;
                sum -= nums[left];
                left++;
                continue;
            }

            if (right < length)
               sum += nums[right];
            right++;
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int target) {
        
          if(target==0)
       {
           int length = nums.length; int count = 0, icr=1;
           for(int i=0;i<length;i++)
           {
               if(nums[i]==0) {count+=icr; icr++;}
               else icr = 1;
           }
           return count;
       }

      return noOfSubarraysGreaterThan(nums,target-1)-noOfSubarraysGreaterThan(nums,target);
    }
}