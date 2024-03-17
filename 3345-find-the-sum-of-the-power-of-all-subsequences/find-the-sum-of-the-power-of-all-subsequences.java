class Solution {
    long mod = (long)(1e9+7);
    long sumOfSubsequence(int index, int lengthOfSubsequence, int k ,int nums[],  Long cache[][][]){
        if(k==0){
            int total = nums.length-lengthOfSubsequence;
            long ans = 1l;
            for(int i=0;i<total;i++){
                ans  = (ans*2)%mod;
            }
            return ans;
        }
        if(index==nums.length)
            return 0l;

        if(cache[index][lengthOfSubsequence][k]!=null)
            return cache[index][lengthOfSubsequence][k];

        long take = 0;
        if(k>=nums[index]) 
            take = sumOfSubsequence(index+1,lengthOfSubsequence+1,k-nums[index],nums,cache);
        long notTake = sumOfSubsequence(index+1,lengthOfSubsequence,k,nums,cache);

        return cache[index][lengthOfSubsequence][k] = (take%mod+notTake%mod)%mod;
    }

    public int sumOfPower(int[] nums, int k) {
        Long cache[][][] = new Long[nums.length][nums.length+1][k+1];
        return (int)sumOfSubsequence(0,0,k,nums,cache);
    }
}