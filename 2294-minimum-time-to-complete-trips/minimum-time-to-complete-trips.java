class Solution {
    boolean isPossibleCompleteTrips(int trips, long totalTime, int time[]) {
        long tripsCompleted = 0;
        for (int index = 0; index < time.length; index++) {
            tripsCompleted += totalTime/(long)time[index];
        }
        return tripsCompleted >= (long)trips;
    }

    int leastTimeToCompleteOneRound(int[] time)
    {
        int length = time.length;
        int minTime = Integer.MAX_VALUE;
        for (int index = 0; index < length; index++)
            minTime = Math.min(minTime, time[index]);
        return minTime;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
	    long right = (long)totalTrips*(long)leastTimeToCompleteOneRound(time);
	    long minTime = right;
	    while(left<=right)
	    {
	    long mid = left+(right-left)/2;
	    if(isPossibleCompleteTrips(totalTrips,mid,time)){ right = mid-1; minTime = mid;}
        else left = mid+1;
        }
        return minTime;

    }
}