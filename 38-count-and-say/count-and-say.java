class Solution {

    String say(String str)
    {
        
        char prev = str.charAt(0);
        int tempCount = 1;
        String nstr = "";

        for(int i=1;i<=str.length();i++)
        {
            char cur  = '\0';
            if(i<str.length()) cur = str.charAt(i);

            if(cur==prev)
            {
                tempCount++;
            }
            else if(i==str.length() || cur!=prev)
            {
                nstr+= (char)(tempCount+48);
                nstr+= prev;
                prev = cur;
                tempCount=1;
            }
        }
        return nstr;
    }

    String rec(int n)
    {
        if(n==1) return "1";
        return say(rec(n-1));
    }
    public String countAndSay(int n) {
     return rec(n);
    }
}