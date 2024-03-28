class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i=0,j=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int length = 0;
        while(i<=j && j<=nums.length)
        {
            if(j<nums.length && map.containsKey(nums[j]) && map.get(nums[j])==k) {
               length =Math.max(length,j-i);
                map.put(nums[i],map.get(nums[i])-1);
                i++;
                continue;
            }else if(j==nums.length)
            {
                length =Math.max(length,j-i);
                break;
            }
            
            if(j<nums.length) {
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            }
            j++;
        }
        
        return length;
    }
}