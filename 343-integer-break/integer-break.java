class Solution {
    int calcMaximumProduct(int n ,int temp, int []dp)
    {

         if(temp<=0)
         {
             if(temp==0) return 1;
             else return 0;
         }

        if(dp[temp]!=-1) return dp[temp];

        int maxi = Integer.MIN_VALUE;
        for(int i=1;i<n;i++)
        {
            int pro = i*calcMaximumProduct(n,temp-i,dp);
            maxi = Math.max(maxi,pro);
        }

        return dp[temp] = maxi;

    }
    public int integerBreak(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);

       return calcMaximumProduct(n,n,dp);
    }
}