class Solution {
    public long continuousSubarrays(int[] nums) {
        int length = nums.length;
        long noOfSubarrays=0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int mini = 0, maxi = 0;
        int right = 0, left = 0;

        while(right<=length) {
            mini = (map.isEmpty())? 0 : map.firstKey();
            maxi = (map.isEmpty())? 0 : map.lastKey();

            if(maxi-mini>2) {
                int leftFreq = map.get(nums[left]);
                if(leftFreq==1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left],leftFreq-1);
                }
                left++;
                continue;
            } else {
                noOfSubarrays+=right-left;
            }
            
            if(right<length) {
                int rightFreq = map.getOrDefault(nums[right],0);
                map.put(nums[right],rightFreq+1);
            }
            right++;
        }

        return noOfSubarrays;
    }
}