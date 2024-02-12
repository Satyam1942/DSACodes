class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int noOfSeeds = plantTime.length;
       int flowers[][] = new int[noOfSeeds][2];
       for(int i=0;i<noOfSeeds;i++){
           flowers[i][0] = growTime[i];
           flowers[i][1]= plantTime[i];
       } 

       Arrays.sort(flowers,(a,b)->b[0]-a[0]);

       int time = 0;
       int elapsedTime = 0;
       for(int i=0;i<noOfSeeds;i++){
           int timeToGrow = flowers[i][0];
           elapsedTime += flowers[i][1];
           time = Math.max(time,elapsedTime+timeToGrow);
       }
       return time;

    }
}


/*
    Planting Time 
    Growth Time 
    I can plant only 1 seed in a day, I can distribute planting of seed on different days
    I can plant seeds in any order
    To find earliest possible day

    1st strategy :
    sort on basis of grow Time in descending Order and calc the answer
    []
    [4,1,3]

 */