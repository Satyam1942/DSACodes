class Solution {
long rec(int index ,int timeFreePainter, int cost[], int time[],Long dp[][])
    {
        if(index==cost.length)
        {
            if(timeFreePainter<=0) return 0;
            else return (long)(1e15);
        }
    if(dp[index][timeFreePainter+cost.length] !=null) return dp[index][timeFreePainter+cost.length];

      long freePainter = rec(index+1,timeFreePainter+1,cost,time, dp);
      int indexLeft = -(time.length-index);
      long paidPainter = (long)cost[index]+
                 rec(index+1,Math.max(timeFreePainter-time[index],indexLeft),cost,time,dp);

      return dp[index][timeFreePainter+cost.length]  = Math.min(freePainter,paidPainter);
    }

    public int paintWalls(int[] cost, int[] time) {
        int  length = cost.length;

        Long dp[][] = new Long[length][length*2+1];
        return (int)rec(0,0,cost,time,dp);
    }
}