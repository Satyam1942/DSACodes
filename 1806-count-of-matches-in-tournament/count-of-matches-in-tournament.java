class Solution {
    public int numberOfMatches(int n) {
        Integer dp[] = new Integer[n+1];
        dp[1] = 0;
        for(int i = 2;i<=n;i++)
        {
            if(i%2==0) dp[i] = i/2 + dp[i/2];
            else dp[i] = (i-1)/2 + dp[(i-1)/2+1];
        }

        return dp[n];
    }
}

/*
14
1 =>14=> 7
2=> 7 => 3
3=> 4 =>2
4=> 2 => 1
 */