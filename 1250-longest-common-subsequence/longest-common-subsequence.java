class Solution {
    int rec(int i,int j, String s1 , String s2 , Integer dp[][]){

        if(i==s1.length()||j==s2.length()) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
           return  dp[i][j] = 1+rec(i+1,j+1,s1,s2,dp);
        }
        else{
            return dp[i][j] =  Math.max(rec(i+1,j,s1,s2,dp),rec(i,j+1,s1,s2,dp));
        }
    }
    public int longestCommonSubsequence(String s1, String s2) {
        Integer dp[][] = new Integer[s1.length()+1][s2.length()+1];

        for(int i=0;i<=s1.length();i++)
            dp[i][s2.length()] = 0;
        for(int i=0;i<=s2.length();i++)
            dp[s1.length()][i] = 0;
            
        for(int i=s1.length()-1;i>=0;i--){
            for(int j=s2.length()-1;j>=0;j--){
                 if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j] = 1+dp[i+1][j+1];
                }
                else{
                    dp[i][j] =  Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }
}