class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        SortedSet<Integer> question = new TreeSet<Integer>();
        List<Integer> list  = new ArrayList<Integer>();
        int prevElement =0 , len =0 , numsLength = nums.length;
        
        for(int i=1;i<numsLength;i++)
        {
          question.add(nums[i]);
        }
        question.add((int) 1e9);
        if(nums.length>0){
        prevElement = nums[0];
        list.add(nums[0]);
        }

      for(int i : question)
      {
           if(prevElement+1 != i) {
               len = Math.max(len, list.size());
               list.clear(); 
              }
            list.add(i);
              prevElement = i;
      }

       return len;
}
}