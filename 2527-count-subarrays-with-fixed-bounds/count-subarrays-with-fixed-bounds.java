class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long noOfSubarrays = 0l;
        int lastInvalidIndex =-1;
        int lastMinKIndex = -1;
        int lastMaxKIndex = -1;

        int lengthOfArray = nums.length;
        for(int i=0;i<lengthOfArray;i++){
            if(nums[i]<minK || nums[i]>maxK){
                lastInvalidIndex = i;
                lastMinKIndex = -1;
                lastMaxKIndex = -1;
            }
            if(nums[i]==minK)
                lastMinKIndex = i;
            if(nums[i]==maxK)
                lastMaxKIndex = i;
            noOfSubarrays += Math.max(0l,Math.min(lastMinKIndex,lastMaxKIndex)-lastInvalidIndex);
        }

        return noOfSubarrays;
    }
}

/*
   1. divide array into subarrays containing minK and maxK
   2. calculate ans for each subarray

   2nd approach no extra space required
   1. use 3 pointers ; badIndex , minIndex, maxIndex 
   2. if(number is not in range) set bad index and reset min and max Index
   3. rest calculation is same as the above approach


   for particular min and max subarray dont think about repaeating min max ahead
   we always extend our subarrays backward so for ahead pointers answer will be  
   covered when we encounter them.
*/