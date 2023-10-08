class Solution {
    int rec(int i,int count , int flip , String s1, String s2, int n, int x,  Integer dp[][][])
    {
        if(i>=n) 
        {
            if(count%2!=0) return (int)(1e8);
            else return (count/2)*x;
        }
        
        if(dp[i][count][flip]!=null) return  dp[i][count][flip];

        int temp = (int)(1e8);
        if((s1.charAt(i)==s2.charAt(i) && flip==0) || (s1.charAt(i)!=s2.charAt(i) && flip==1))
        {
            temp = rec(i+1,count,0,s1,s2,n,x,dp);
        }
        else
        {
            int case1 = Integer.MAX_VALUE;
            if(i!=n-1) case1 =  1+rec(i+1,count,1, s1,s2,n,x,dp);
            int case2 = rec(i+1,count+1,0,s1,s2,n,x,dp);
            temp =  Math.min(case1,case2);
        }

         return dp[i][count][flip] = temp;
    }
    public int minOperations(String s1, String s2, int x) {
        int n = s1.length();

        Integer dp[][][] = new Integer[n][n][2];
        int temp =   rec(0,0,0,s1,s2,n,x,dp);
        if(temp==(int)(1e8)) return -1;
        else return temp;
            
    }
}