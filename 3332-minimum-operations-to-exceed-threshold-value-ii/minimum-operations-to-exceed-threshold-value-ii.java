class Solution {
    public int minOperations(int[] nums, int k) {
       TreeMap<Long,Integer> map = new TreeMap<>();
        int opr = 0;
        
        for(int i=0;i<nums.length;i++){
            map.put((long)nums[i],map.getOrDefault((long)nums[i],0)+1);
        }
        
        while(!map.isEmpty() && map.firstKey()<k){
            
            long x = map.firstKey();
            if(map.get(x)==1)
                map.remove(x);
            else
                map.put(x,map.get(x)-1);
            
            if(map.isEmpty())
                break;
            
            long y = map.firstKey();
            if(map.get(y)==1)
                map.remove(y);
            else
                map.put(y,map.get(y)-1);
            
            long z = Math.min(x, y) * 2l + Math.max(x, y);
            map.put(z,map.getOrDefault(z,0)+1);
            
            opr++;
        }
        
        return opr;
    }
}