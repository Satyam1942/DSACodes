class Solution {

    int rec(int n,Integer cache[]){
        if(n==1 || n==0) return 1;
        if(n<0) return 0;
        if(cache[n]!=null) return cache[n];

        return cache[n] = rec(n-1,cache)+rec(n-2,cache);
    }

    public int climbStairs(int n) {
        Integer cache[] = new Integer[n+1];
        return rec(n,cache);
    }
}