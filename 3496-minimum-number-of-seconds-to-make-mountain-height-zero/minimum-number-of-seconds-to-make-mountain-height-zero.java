class Solution {
    boolean isPossible(long time, int workerTimes[] , int maxHeight) {
        int heightReduced = 0;
        int length = workerTimes.length;

        for(int i=0;i<length;i++){
            int curHeightReduced = (int)((Math.sqrt(1+8*time/(double)workerTimes[i])-1)/2.0);
            heightReduced += curHeightReduced;
        }

        return heightReduced>=maxHeight;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        Arrays.sort(workerTimes);
        long left = 0;
        long right = workerTimes[0]*((long)mountainHeight*((long)mountainHeight+1l))/2;
        long minNumberSeconds = right;

        while(left<=right){
            long mid = (left+right)/2;
            if(isPossible(mid, workerTimes, mountainHeight)) {
                minNumberSeconds = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        } 

        return minNumberSeconds;
    }
}