class Solution {
    public int lengthOfLastWord(String s) {
     int f =0;
        
     for(int i = s.length()-1;i>=0;i--)
     {
         if(f==0 && s.charAt(i)==' ') continue;
         if(s.charAt(i)==' ') return f;
         else f++;
     }  
     return f; 
    }
}