class Solution {
 public int numberOfArithmeticSlices(int[] nums) {
        HashMap<Long,Integer>[] cache = new HashMap[nums.length];
        for(int i=0;i<nums.length;i++) cache[i] = new HashMap<>();

           int count = 0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                long dif = (long)nums[i]-(long)nums[j];
                int freq = cache[i].getOrDefault(dif,0)+cache[j].getOrDefault(dif,0);
                count+=cache[j].getOrDefault(dif,0);
                cache[i].put(dif,freq+1);
            }
        }       

     return count;

    }
}