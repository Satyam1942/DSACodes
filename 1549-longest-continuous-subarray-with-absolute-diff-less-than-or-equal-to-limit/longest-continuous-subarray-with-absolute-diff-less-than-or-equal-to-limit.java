class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int length = nums.length;
        int left  = 0;
        int right = 0;

        int maxLengthSubarray = 0;

        while(right<length){
            int freq = map.getOrDefault(nums[right],0);
            map.put(nums[right],freq+1);

            while(left<right && map.lastKey()-map.firstKey()>limit){
                freq = map.get(nums[left]);
                if(freq==1)
                    map.remove(nums[left]);
                else
                    map.put(nums[left],freq-1);
                left++;
            }

            maxLengthSubarray = Math.max(right-left+1,maxLengthSubarray);
            right++;
        }

        return maxLengthSubarray;
    }
}