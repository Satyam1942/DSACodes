class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int left = 0;
        int right = 0;
        long count = 0;
        long pairCount = 0;

        int length = nums.length;
        while(right<=length) {
            if(pairCount>=k) {
                count+= (length-right+1);
                int curFreq = freq.getOrDefault(nums[left],0);
                pairCount-=(curFreq-1);
                if(curFreq==1){
                    freq.remove(nums[left]);
                } else {
                    freq.put(nums[left], curFreq-1);
                }
                left++;
                continue;
            }

            if(right<nums.length) {
                int curFreq = freq.getOrDefault(nums[right],0);
                pairCount+=curFreq;
                freq.put(nums[right],curFreq+1);
            }
            right++;
        }

        return count;
    }
}