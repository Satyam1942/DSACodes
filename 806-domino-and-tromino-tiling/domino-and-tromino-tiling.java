class Solution {
    long mod = (long)(1e9+7);
    long recursion(int n, Long cache[]) {
        if(n<0) {
            return 0l;
        }
        if (n==1 || n==0) {
            return cache[n] = 1l;
        }

        if(cache[n]!=null ){
            return cache[n];
        }
        return cache[n] = ((2l*recursion(n-1, cache))%mod + recursion(n-3, cache)%mod)%mod;
    }

    public int numTilings(int n) {
        Long cache[] = new Long[n+1];
        return (int)recursion(n,cache);
    }
}