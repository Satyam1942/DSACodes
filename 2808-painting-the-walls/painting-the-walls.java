class Solution {
long rec(int index ,int wallsLeft, int cost[], int time[],Long dp[][])
    {
        if(wallsLeft<=0) return 0;
        if(index==cost.length) return (long)(1e15);
        
    if(dp[index][wallsLeft] !=null) return dp[index][wallsLeft];

      long freePainter = rec(index+1,wallsLeft,cost,time, dp);
      long paidPainter = (long)cost[index]+ rec(index+1,wallsLeft-time[index]-1,cost,time,dp);

      return dp[index][wallsLeft]  = Math.min(freePainter,paidPainter);
    }

    public int paintWalls(int[] cost, int[] time) {
        int  length = cost.length;
        Long dp[][] = new Long[length][length+1];
        return (int)rec(0,cost.length,cost,time,dp);
    }
}