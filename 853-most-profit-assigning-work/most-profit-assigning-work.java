class Job{
    int difficulty;
    int profit;
    Job(int difficulty,int profit){
        this.difficulty = difficulty;
        this.profit = profit;
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int noOfJobs = difficulty.length;
        int noOfWorkers = worker.length;
        Job arrayOfJobs[] = new Job[noOfJobs];

        for(int i=0;i<noOfJobs;i++){
            arrayOfJobs[i] = new Job(difficulty[i],profit[i]);
        }

        Arrays.sort(arrayOfJobs,(a,b)->(a.difficulty-b.difficulty));
        Arrays.sort(worker);

        int totalProfit = 0;
        int maxProfit = 0;
        int pointer = 0;

        for(int i=0;i<worker.length;i++){
     
            while(pointer<noOfJobs && worker[i]>=arrayOfJobs[pointer].difficulty){
                maxProfit = Math.max(maxProfit,arrayOfJobs[pointer].profit);
                pointer++;
            } 
            totalProfit+= maxProfit;
        }

        return totalProfit;
    }
}
/*
    10,50
    8,40
    6,30
    4,20
    2,10

 */ 