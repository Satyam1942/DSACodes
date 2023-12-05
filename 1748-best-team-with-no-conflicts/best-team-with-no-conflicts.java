class Solution {
    int rec(int index, int prevIndex , int[][] map,  Integer dp[][])
    {
        if(index==map.length)  return 0;
        if(dp[index][prevIndex]!=null) return dp[index][prevIndex];

        int take = Integer.MIN_VALUE;
        if(prevIndex-1==-1 || map[index][1]>=map[prevIndex-1][1]) 
        take = map[index][1]+rec(index+1,index+1,map,dp);

        int notTake = rec(index+1,prevIndex,map,dp);

        return dp[index][prevIndex] = Math.max(take,notTake);
    }


    public int bestTeamScore(int[] scores, int[] ages) {
        int noOfPlayers = scores.length;
       int[][] map = new int[scores.length][2];
       for(int i=0;i<noOfPlayers;i++)
       {
           map[i][0] = ages[i];
           map[i][1] = scores[i];
       }

       Arrays.sort(map,(a,b)->((a[0]==b[0])?a[1]-b[1]:a[0]-b[0]));

        Integer dp[][] = new Integer[noOfPlayers+1][noOfPlayers+1];
       return rec(0,0,map,dp);
    }
}

/*
   edges cases:
   age->score

   1,1,2,2

   2->6
   2->4
   1->5
   1->5

   

 */