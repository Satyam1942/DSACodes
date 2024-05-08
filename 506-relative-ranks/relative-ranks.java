class Solution {
    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        String arr[] = new String[len];
        TreeMap<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<len;i++)
        {
            map.put(score[i],i);
        }
        int rank=0;
       for(Map.Entry<Integer,Integer> i : map.entrySet())
       {
           if(rank==0)
           arr[i.getValue()] = "Gold Medal";
           
           else if(rank==1)
           arr[i.getValue()] = "Silver Medal";
           
          else if(rank==2)
           arr[i.getValue()] = "Bronze Medal";
          else 
           arr[i.getValue()] = String.valueOf((rank+1));
           
           rank++;
        }

            
            return arr;
    }
}