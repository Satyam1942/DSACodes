class Solution {
     public int minimumIndex(List<Integer> nums) {
      
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.size();
        for(int i=0;i<nums.size();i++)
        {
            int val = map.getOrDefault(nums.get(i),0);
            map.put(nums.get(i),val+1);
        }
        int dominantTerm=0,dominantTermFreq=0;

        for(Map.Entry<Integer,Integer> i: map.entrySet())
        {
            if(i.getValue()>dominantTermFreq)
            {
                dominantTermFreq = i.getValue();
                dominantTerm= i.getKey();
            }
        }
         

         int count =0,index=-1;
         for(int i=0;i<nums.size();i++)
         {
             if(nums.get(i)==dominantTerm) count++;

             if(count>(i+1)/2) {index = i;break;}
         }

          int leftDominantCount =  dominantTermFreq-count;
     

          if(leftDominantCount  > ((n-index-1)/2)) return index;

        return -1;
    }
        
}