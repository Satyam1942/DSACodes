class Solution {
    int rec(String s , int i , int j , HashSet<String> dictionarySet,int dp[][])
    {
        if(i==j)
        {
            if(dictionarySet.contains(s.substring(i,j+1))) return 0;
            else return 1;
        }
       
        if(dictionarySet.contains(s.substring(i,j+1))) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int countLeft =0 , countRight = 0, mini = Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            String leftSubstr = s.substring(i,k+1);
            if(!dictionarySet.contains(leftSubstr)) countLeft = leftSubstr.length();
            else countLeft = 0;
            countRight = rec(s,k+1,j,dictionarySet,dp);
            mini = Math.min(mini , countRight+countLeft);
        }

        return dp[i][j] =  mini;
    }
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> dictionarySet = new HashSet<>();
        int len = s.length();
        for(int i=0;i<dictionary.length;i++) dictionarySet.add(dictionary[i]);

        int dp[][] = new int[len][len];
        for(int row[] :dp) Arrays.fill(row,-1);
        return rec(s,0,s.length()-1,dictionarySet,dp);

    }
}