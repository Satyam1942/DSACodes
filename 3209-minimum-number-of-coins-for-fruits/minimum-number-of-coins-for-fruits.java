class Solution {
    int rec(int index,int [] prices,Integer dp[])
    {
        if(index>=prices.length) return 0;
        if(dp[index]!=null) return dp[index];

        int take = Integer.MAX_VALUE;

        for(int i=1;i<=index+2;i++)
        {
            int temp = prices[index]+ rec(index+i,prices,dp);
            take = Math.min(take,temp);
        }

        return dp[index] = take;
    }

    public int minimumCoins(int[] prices) {
        Integer dp[] = new Integer [prices.length];
        return rec(0,prices,dp);
    }
}