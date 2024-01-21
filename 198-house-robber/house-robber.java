class Solution {
   
    public int rob(int[] nums) {
         // Your code here
         int len = nums.length;
         int next =0,nextNext=0;
       

        for(int i=len-1;i>=0;i--)
        {
            int notPick=0,pick=0;
            notPick = 0 + next;
            pick = nums[i] + nextNext; 
          
          nextNext = next;
           next =  Math.max(pick,notPick); 

        }

        return next;

    }
}