class Solution {
    int rec(int index, int taken,String s,int dp[][] )
    {
        if(index==s.length()) if(taken==0 )return 1; else return 0;
        if(s.charAt(index)=='0' && taken ==0) return 0;
        if(dp[index][taken]!=-1) return dp[index][taken];
        int notTake =0 , take=0;
        if(taken==0)
        {
             notTake = rec(index+1,0,s,dp);
            take = rec(index+1,1,s,dp);
        }
        if(taken==1)
        {
            String st=s.substring(index-1,index+1);
            if(Integer.parseInt(st)<=26)
            take = rec(index+1,0,s,dp);
        }

        return dp[index][taken]= take+notTake;
        
    }
    public int numDecodings(String s) {
       int dp[][] = new int[s.length()][2];
       for(int rows[]: dp) Arrays.fill(rows,-1);

       return rec(0,0,s,dp);
    }
}