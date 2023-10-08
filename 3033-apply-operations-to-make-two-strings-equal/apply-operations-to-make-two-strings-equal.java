class Solution {
    int rec(int i,int count , int flip , String s1, String s2, int n, int x,  Integer dp[][][])
    {
        if(i>=n) 
        {
            if(count%2!=0) return (int)(1e8);
            else return (count/2)*x;
        }
        
        if(dp[i][count][flip]!=null) return  dp[i][count][flip];

        if((s1.charAt(i)==s2.charAt(i) && flip==0) || (s1.charAt(i)!=s2.charAt(i) && flip==1))
        {
            return dp[i][count][flip] = rec(i+1,count,0,s1,s2,n,x,dp);
        }
        else
        {
            int case1 = 1+rec(i+1,count,1, s1,s2,n,x,dp);
            int case2 = rec(i+1,count+1,0,s1,s2,n,x,dp);
            return dp[i][count][flip] =  Math.min(case1,case2);
        }
    }
    public int minOperations(String s1, String s2, int x) {
        int noOfChanges = 0;
        int n = s1.length();
        for(int i=0;i<n;i++)
        {
            if(s1.charAt(i)!=s2.charAt(i)) noOfChanges++;
        }
        
        if(noOfChanges%2!=0) return -1;

        Integer dp[][][] = new Integer[n][n][2];
       return  rec(0,0,0,s1,s2,n,x,dp);
            
    }
}