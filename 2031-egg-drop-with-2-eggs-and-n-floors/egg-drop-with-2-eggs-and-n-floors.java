class Solution {
    int rec(int floor , Integer dp[] ){
        if(floor==0)
            return 0;
        if(dp[floor]!=null)
            return dp[floor];

        int mini = Integer.MAX_VALUE;
        for(int i=1;i<=floor;i++){            
            int eggBreaks = i;
            int eggNotBreaks = 1+rec(floor-i,dp);
            mini = Math.min(mini , Math.max(eggBreaks,eggNotBreaks));
        }
        return  dp[floor] = mini;
    }
    public int twoEggDrop(int n) {
        Integer dp[] = new Integer[n+1];
        return rec(n,dp);
    }
}