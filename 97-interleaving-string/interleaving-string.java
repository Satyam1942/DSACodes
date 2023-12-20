class Solution {
   boolean rec(String s1 , String s2, String s3, int i, int j, Boolean dp[][])
    {
        if(i+j == s3.length()) return  true;

        if(dp[i][j]!=null) return dp[i][j];

        boolean posA = false , posB = false;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j)) posA =  rec(s1,s2,s3,i+1,j,dp);
        if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j)) posB =  rec(s1,s2,s3,i,j+1,dp);
        return  dp[i][j] = posA||posB;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
       
       if(s3.length() != n+m) return false;
        Boolean dp[][] = new Boolean[s1.length()+1][s2.length()+1];

      return rec(s1,s2,s3,0,0,dp);
    }
}