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
    public int longestCommonSubsequence(String text1, String text2) {
        Integer dp[][] = new Integer[text1.length()][text2.length()];
        return rec(0,0,text1,text2,dp);
    }
}