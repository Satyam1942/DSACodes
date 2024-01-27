class Solution {
    public int kInversePairs(int n, int k) {
        long mod = (long)(1e9+7);

        long prev[] = new long[k+1];
        //base case
        prev[0] = 1;
        
       for(int i=1;i<=n;i++){
           
            long cur[] = new long[k+1];
            long total = 0; // sliding window using total variable
            
            for(int j=0;j<=k;j++){
                if(j>=i) // remove from window 
                    total= (mod + total-prev[j-i])%mod;
            
                total = (total + prev[j])%mod; // add to sliding window
                cur[j] = total;
            }

            prev = cur;
        }
        
        return (int)prev[k];
    }
}

/*
HERE DP[n][k] represents no of arrays of size n with k reverse pairs
We use sliding window to optimize from n*n*k to n*k
This is only possible using the tabulation approach

Further I have space optimised dp[n][k] using prev and cur cause for filling 
current array we only need one array previous instead of all arrays from 0 to n
*/