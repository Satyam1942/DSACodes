class Solution {
    public long minTime(int[] skill, int[] mana) {
        int noOfWizard = skill.length;
        int noOfPotions = mana.length;
        long prefixSum[] = new long[noOfWizard];
        long cache[] = new long[noOfWizard];
        long endTime = 0;

        for(int i=0; i<noOfWizard; i++) {
            prefixSum[i] = (i==0)? skill[i] : prefixSum[i-1]+skill[i];
        }

        for(int i=0;i<noOfWizard; i++) {
            cache[i] = mana[0]*prefixSum[i];
        }

        for(int i=1; i<noOfPotions; i++) {
            long startTime = cache[0];
            for(int j=noOfWizard-1; j>0; j--) {
                long predictedStartTime = cache[j]-mana[i]*prefixSum[j-1];
                startTime = Math.max(startTime, predictedStartTime);
            }
            for(int j=0; j<noOfWizard; j++) {
                cache[j] = startTime + mana[i]*prefixSum[j];
            }
        }

        endTime = cache[noOfWizard-1];
        return endTime;
    }
}

/*
   prefixArray = 3, 8, 11, 20

    step 1 calcute this prefix array
    3, 8, 11, 20

    start from max(prevStart+1, prevEnd - secondLastCur)
*/