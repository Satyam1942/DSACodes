class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        int noOfChalks = chalk.length;
        for(int i=0;i<noOfChalks;i++){
            sum+=chalk[i];
            if(sum>k)
                return i;
        }
        
        k-= (k/sum) * sum;
        long runningSum = 0;
    
        for(int i=0;i<noOfChalks;i++){
            runningSum+=chalk[i];
            if(runningSum>k)
                return i;
        }

        return -1;
    }
}