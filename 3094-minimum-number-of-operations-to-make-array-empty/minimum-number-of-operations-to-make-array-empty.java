class Solution {
    public int minOperations(int[] nums) {
     HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }    
        
        int count = 0,temp=0;
        for(Map.Entry<Integer,Integer> i :map.entrySet())
        {
            
            int freq = i.getValue();
            if(freq==1) return -1;
            if(freq%3==0)
            {
                count+= freq/3;
            }
            else if((freq-1)%3==0)
            {
                count+=  ((freq-1)/3 -1) + 2; 
            }
            else if((freq-2)%3==0)
            {
                count+=(freq-2)/3 + 1;
            }
        }
        
        
        return count;
        
    }
}