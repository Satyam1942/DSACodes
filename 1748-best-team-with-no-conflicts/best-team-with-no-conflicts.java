class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int noOfPlayers = scores.length;
       int[][] map = new int[scores.length][2];
       for(int i=0;i<noOfPlayers;i++)
       {
           map[i][0] = ages[i];
           map[i][1] = scores[i];
       }

       Arrays.sort(map,(a,b)->((a[0]==b[0])?a[1]-b[1]:a[0]-b[0]));

        int dp[][] = new int[noOfPlayers+1][noOfPlayers+1];
        for(int index = noOfPlayers-1;index>=0;index--)
        {
            for(int prevIndex = noOfPlayers;prevIndex>=0;prevIndex--)
            {
                int take = Integer.MIN_VALUE;
                if(prevIndex-1==-1 || map[index][1]>=map[prevIndex-1][1]) 
                 take = map[index][1]+ dp[index+1][index+1];

                int notTake = dp[index+1][prevIndex];

                dp[index][prevIndex] = Math.max(take,notTake);   
            }
        }


       return dp[0][0];
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