class Solution {
    
     boolean isPalindrome(int n)
    {
        int x = n;
        int rev = 0;
       while(x>0)
       {
           int d= x%10;
           rev*=10;
           rev+=d;
           x=x/10;
       }
        
        return rev==n;
    }
    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
    
            int num1 = nums[length/2];
            int num2 = nums[length/2];
            
            while(!isPalindrome(num1)) num1++;
            while(!isPalindrome(num2)) num2--;
  
            long score1 = 0, score2 =0;
            for(int i=0;i<length;i++)
            {
                score1+= Math.abs(nums[i]-num1);
                score2+= Math.abs(nums[i]-num2);
            }
            return Math.min(score1,score2);
    }
}
/*

22,33
22,22,22,33,33
*/