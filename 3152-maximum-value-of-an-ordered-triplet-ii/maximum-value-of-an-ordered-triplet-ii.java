class Solution {
    public long maximumTripletValue(int[] nums) {
       TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=2;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        int a = nums[0];
        long product = 0;
        for(int j = 1;j<nums.length-1;j++)
        {
            int  k = map.lastKey();
            product = Math.max(product,(long)k*((long)a-(long)nums[j]));
            a = Math.max(a,nums[j]);
            if(map.get(nums[j+1])==1) map.remove(nums[j+1]);
            else map.put(nums[j+1],map.get(nums[j+1])-1);
        }
        
        return product;
    }
}