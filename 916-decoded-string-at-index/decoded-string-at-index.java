class Solution {
    public String decodeAtIndex(String s, int k) {
       long totalLength = 0;
       for(int i=0;i<s.length();i++)
       {
           if(s.charAt(i)>=48 && s.charAt(i)<=57 )
           {
               totalLength+= totalLength*(long)(s.charAt(i)-49);
           }
           else totalLength++;
       }

       for(int i = s.length()-1;i>=0;i--)
       {
           if(s.charAt(i)>=48 && s.charAt(i)<=57)
           {
               totalLength/=(s.charAt(i)-48);
               k = (int)((long)k%totalLength);
           }
           else
           {
               if(totalLength==k || k==0) return String.valueOf(s.charAt(i));
               totalLength--;
           }
       }

       return "";
    }
}