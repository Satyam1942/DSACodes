class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
       int length = nums.length;
       HashMap<Long,Long>[] cache = new HashMap[length];

       for(int i=0;i<length;i++)
            cache[i] = new HashMap<>();

       for(int i = length-2;i>=0;i--){
            for(int j= i+1;j<length;j++){
                long dif = (long)nums[j]-(long)nums[i];
                long val = (cache[j].containsKey(dif))? cache[j].get(dif): 0;
                long curVal = (cache[i].containsKey(dif))? cache[i].get(dif): 0;
                cache[i].put(dif,curVal+ val+1);
            }
       }

        long sum = 0;
        for(int i=0;i<length;i++){
            HashMap<Long,Long> temp = cache[i];
            for(Map.Entry<Long,Long> j: temp.entrySet())
                sum+= j.getValue();
        }
  
        int noOfSubsequences = (int)(sum-(length*(length-1))/2);
        return noOfSubsequences;
    }
}