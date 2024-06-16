class Solution {
    public int minPatches(int[] nums, int n) {
        long prefixSum = 0;
        int count = 0;
        int length = nums.length;
    
        for(int i=0;i<length;){
            if(prefixSum>=n)
                break;
            if(prefixSum+1<nums[i]){
                count++;
                prefixSum+= (prefixSum+1);
            }else{
                prefixSum+=nums[i];
                i++;
            }
        }

        while(prefixSum<n){
            prefixSum+=(prefixSum+1);
            count++;
        }

        return count;
    }
}
/*
  Sorting is necessary !! As its already sorted ; no need to sort again!!
 */