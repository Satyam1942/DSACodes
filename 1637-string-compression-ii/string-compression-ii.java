class Solution {
    int rec(int index, int k, char prev , int prevCount , String s,Integer dp[][][][])
    {
        if(k<0) return Integer.MAX_VALUE;
        if(index==s.length()) return 0;
        if(dp[index][k][(int)prev-96][prevCount]!=null) return dp[index][k][(int)prev-96][prevCount];

        int res = 0;
        if(prev==s.charAt(index))
        {
            int increment = (prevCount==1 || prevCount==9 || prevCount==99) ? 1:0;
            res = increment + rec(index+1,k,prev,prevCount+1,s,dp);
        }
        else
        {
            int delete = rec(index+1,k-1,prev,prevCount,s,dp);
            int notDelete = 1+rec(index+1,k,s.charAt(index),1,s,dp);
            res = Math.min(delete,notDelete);
        }

        return dp[index][k][(int)prev-96][prevCount] = res;
    }
    public int getLengthOfOptimalCompression(String s, int k) {
        Integer dp[][][][] = new Integer[s.length()][k+1][27][101];
        return rec(0,k,(char)(96),0,s,dp);
    }
}