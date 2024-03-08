class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        int maxFreq = 0;
        for(Map.Entry<Integer,Integer> i :map.entrySet())
        {
            int freq = i.getValue();
            maxFreq = Math.max(maxFreq,freq);
        }
        
        int count = 0;
        for(Map.Entry<Integer,Integer> i : map.entrySet())
        {
            int freq = i.getValue();
            if(freq==maxFreq) count++;
        }   
        
        return count*maxFreq;
    }
}