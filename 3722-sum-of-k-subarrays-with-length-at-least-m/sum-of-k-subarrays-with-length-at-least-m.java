class Solution {
    int recursion(int index, int noOfSubarraysSelected, int isInSubarray,  int m, int k, int nums[], int prefixMSum[], Integer cache[][][]) {
        if(index == nums.length) {
            if(noOfSubarraysSelected==k) {
                return 0;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        if(cache[index][noOfSubarraysSelected][isInSubarray]!=null) {
            return cache[index][noOfSubarraysSelected][isInSubarray];
        }

        int skip = Integer.MIN_VALUE;
        int start = Integer.MIN_VALUE;
        int continueSubArray = Integer.MIN_VALUE;

        skip = recursion(index+1, noOfSubarraysSelected, 0, m, k, nums, prefixMSum, cache);

        if(noOfSubarraysSelected<k && prefixMSum[index]!=Integer.MAX_VALUE) {
            start = recursion(index+m, noOfSubarraysSelected+1, 1, m, k, nums, prefixMSum, cache);
        }

        if(isInSubarray==1) {
            continueSubArray =  recursion(index+1, noOfSubarraysSelected, 1, m, k, nums, prefixMSum, cache); 
        }

        if(start!=Integer.MIN_VALUE) {
            start += prefixMSum[index];
        }

        if(continueSubArray!=Integer.MIN_VALUE) {
            continueSubArray += nums[index];
        }
       
        return cache[index][noOfSubarraysSelected][isInSubarray] = Math.max(Math.max(skip, continueSubArray), start);   
    }

    public int maxSum(int[] nums, int k, int m) {
        int length = nums.length;
        int prefixMSum[] = new int[length];
        for(int i=0;i<length;i++) {
            int sum = 0;
            if(i+m>length) {
                prefixMSum[i] = Integer.MAX_VALUE;
                continue;
            }
            for(int j=i;j<i+m;j++) {
                sum+=nums[j];
            }
            prefixMSum[i] = sum;
        }

        Integer cache[][][] = new Integer[length][k+1][2];
        return recursion(0, 0, 0, m, k, nums, prefixMSum, cache);
    }
}


/*
    length = 6
    maxSubarrayLength = length/k
    minSubarrayLength = m
    [2,3]
    [1, 2, -1, 3, 3, 4]

*/