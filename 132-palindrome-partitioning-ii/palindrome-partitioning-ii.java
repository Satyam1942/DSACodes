class Solution {
  int rec(String s, int i, Integer dp[])
    {
        if(i>=s.length()-1) return 0;
        if(dp[i]!=null) return  dp[i];

        int mini = Integer.MAX_VALUE;

        String x = "", xRev = "";
        
        for(int k = i;k<s.length();k++)
        {
             x += s.charAt(k);
             xRev = s.charAt(k)+xRev;
            if(x.equals(xRev))
            {
                int temp  = 0;
                if(k==s.length()-1) temp = rec(s,k+1,dp);
                else temp = 1+rec(s,k+1,dp);
                mini = Math.min(temp,mini);
            }
        }

        return dp[i] =  mini;
    }
    
    public int minCut(String s) {
         Integer dp[] = new Integer[s.length()+1];
         return rec(s,0,dp);
    }
}