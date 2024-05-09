class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int length = happiness.length;
        Arrays.sort(happiness);
        long happinessValue = 0;
        int pointer = length-1;
    
        for(int i=0;i<k;i++){
            happinessValue+= Math.max(happiness[pointer]-i,0);
            pointer--;
        }
        return happinessValue;
    }
}