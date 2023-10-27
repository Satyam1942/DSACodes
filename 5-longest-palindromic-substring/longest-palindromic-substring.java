class Solution {
    
   public String longestPalindrome(String s) {
   int len = s.length();
   int lowerBound=0,upperBound=0,maxi =0;
   for(int centre =0;centre<len;centre++)
   {
        int left = centre;
       int right=centre;
        int count=0;
       while(left>=0 && right<len)
       {  
         if(s.charAt(left)==s.charAt(right)) count++;
           else break;
            left--;
            right++;
       }
    if(count>maxi)
    {
        maxi =count;
        lowerBound = left+1;
        upperBound = right-1;
    }
   }

    for(int centre =0;centre<len;centre++)
    {
        int left = centre;
       int right=centre+1;
        int count=1;
       while(left>=0 && right<len)
       {  
         if(s.charAt(left)==s.charAt(right)) count++;
           else break;
            left--;
            right++;
       }
    if(count>maxi)
    {
        maxi =count;
        lowerBound = left+1;
        upperBound = right-1;
    }
   }


   return s.substring(lowerBound,upperBound+1);      
    }
}