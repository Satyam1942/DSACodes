class Solution {
    String rec(String s, int k)
    {
        long count =0;
        String validSubstr = "";

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)<=57 && s.charAt(i)>=48)
            {
                if(count+((s.charAt(i)-48)-1)*count>=(long)k) break;
                count+= ((s.charAt(i)-48)-1)*count;
            }
            else 
            {
            count++;
            }
            if(count==k) return String.valueOf(s.charAt(i));
            if(count>k) break;
             validSubstr+= s.charAt(i);
        }
        return rec(validSubstr,(k-1)%(int)count+1);
    }
    public String decodeAtIndex(String s, int k) {
       return rec(s,k); 
    }
}