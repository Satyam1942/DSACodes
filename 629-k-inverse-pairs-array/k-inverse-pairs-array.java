class Solution {
    public int kInversePairs(int n, int k) {
        int mod = (int)(1e9+7);

        int cache[][] = new int[n+1][k+1];
        cache[1][0] = 1;

        for(int i=2;i<=n;i++){
            int sum = 0;
            for(int j=0;j<=k;j++){
                if(j<=i-1){
                    sum = (sum+cache[i-1][j])%mod;
                    cache[i][j] = sum;
                }else{
                    sum = (sum+cache[i-1][j])%mod;
                    sum = (sum-cache[i-1][j-i]+mod)%mod;
                    cache[i][j] = sum;
                }
            }
        }
        
        return cache[n][k];

    }
}