class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        
        int ans[] = new int[2];
        ans[0]=-1;
        ans[1]=-1;

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        int minIndex = -1;
        int maxIndex = -1;
        int maxDiffArray[] = new int[nums.length];
        for(int i=indexDifference;i<nums.length;i++)
        {
            if(mini>nums[i-indexDifference])
            {
            mini = nums[i-indexDifference];
            minIndex = i-indexDifference;
            }
            if(maxi<nums[i-indexDifference])
            {
            maxi = nums[i-indexDifference];
            maxIndex = i-indexDifference;
            }

            if(Math.abs(maxi-nums[i])>=valueDifference)
            {
                ans[0] = maxIndex;
                ans[1] = i;
                return ans;
            }
            else if(Math.abs(mini-nums[i])>=valueDifference)
            {
                ans[0] = minIndex;
                ans[1]= i;
                return ans;
            }
        }

        return ans;
    }
}

/*
    greater    less
  `   9-{2}    1-{2}
      5-{3}    -3-{3}
      8-{4}    0-{4}


      greater   less
      5-{2}      -4-{2}
      6-{3}      -2-{3}
      7-{}


 */