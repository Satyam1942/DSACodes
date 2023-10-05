class Solution {
    public int majorityElement(int[] nums) {
        
      //MOOR'S VOTING ALGO

      int n = nums.length;


      int current=Integer.MAX_VALUE;
      int counter = 0;
      int right=0;

    
      while(right<n)
      {
        if(nums[right]==current) counter++;
        else if(counter==0)
        {
            counter=1;
            current = nums[right];
        }
        else counter--;
        
        right++;
      }

     return current;

}
}