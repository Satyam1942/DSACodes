class Solution {
 public int numberOfArithmeticSlices(int[] nums) {
        HashMap<Long,Integer>[] cache = new HashMap[nums.length];
        for(int i=0;i<nums.length;i++) cache[i] = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                long dif = (long)nums[i]-(long)nums[j];
                int freq = cache[i].getOrDefault(dif,0)+cache[j].getOrDefault(dif,0);
                cache[i].put(dif,freq+1);
            }
        }       

        int count = 0;

        for(int i=0;i<nums.length;i++)
        {
            HashMap<Long,Integer> map = cache[i];
            for(Map.Entry<Long,Integer> j:map.entrySet())
            {
                long dif = j.getKey();
                int freq = j.getValue();
                count+=freq;
            }
        }
        int n = nums.length;
        return count-(n*(n-1))/2;
    }
}