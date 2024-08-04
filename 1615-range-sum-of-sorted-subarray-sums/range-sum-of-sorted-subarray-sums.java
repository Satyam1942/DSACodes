class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Long> subArraySumList = new ArrayList<>();
        int length = nums.length;
        long prefixSumArray[] = new long[length];
        long mod =  (long)(1e9+7);

        prefixSumArray[0] = nums[0];
        for(int i=1;i<length;i++)
            prefixSumArray[i] = prefixSumArray[i-1]+nums[i];
            
        for(int i=0;i<length;i++){
            for(int j=i;j<length;j++){
                long subArraySum = (i-1>=0)? prefixSumArray[j]-prefixSumArray[i-1]: prefixSumArray[j];
                subArraySumList.add(subArraySum);
            }
        }

        Collections.sort(subArraySumList);

        List<Long> prefixSumSubArrayList = new ArrayList<>();
        prefixSumSubArrayList.add(subArraySumList.get(0));
        for(int i=1;i<subArraySumList.size();i++) {
            long prev = prefixSumSubArrayList.get(prefixSumSubArrayList.size()-1); 
            prefixSumSubArrayList.add(prev+subArraySumList.get(i));
        } 

        long ans = (left-2>=0)? prefixSumSubArrayList.get(right-1) - prefixSumSubArrayList.get(left-2) : prefixSumSubArrayList.get(right-1);

        return (int)(ans%mod);
    }
}