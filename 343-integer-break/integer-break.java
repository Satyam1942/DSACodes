class Solution {

    public int integerBreak(int n) {
        int dp[] = new int[n+1];
        dp[0]=1;

        for(int temp = 1;temp<=n;temp++)
        {
            int maxi = Integer.MIN_VALUE;
            for(int i=1;i<n;i++)
            {
                int pro = Integer.MIN_VALUE;
                 if(temp>=i) 
                    pro = i*dp[temp-i];
                maxi = Math.max(maxi,pro);
            }
             dp[temp] = maxi;
        }

       return dp[n];
    }
}