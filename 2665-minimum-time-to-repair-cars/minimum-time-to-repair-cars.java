class Solution {
    boolean isPossible(long time, int ranks[], int carsRequiredToRepair) {
        int length = ranks.length;
        long carsRepairedWithGivenTime = 0;
        for(int i=0;i<length;i++) {
            int curRank = ranks[i];
            carsRepairedWithGivenTime += (int)Math.sqrt(time/(double)curRank);
        }
        return carsRepairedWithGivenTime>=carsRequiredToRepair;
    }

    public long repairCars(int[] ranks, int cars) {
        long left = 0;
        long right = (long)cars*(long)cars*(long)Arrays.stream(ranks).max().getAsInt();
        long minTime = right;

        while(left<=right) {
            long mid = left + (right-left)/2;
            if(isPossible(mid, ranks, cars)) {
                right = mid-1;
                minTime = mid;
            } else {
                left = mid+1;
            }
        }
        return minTime;
    }
}