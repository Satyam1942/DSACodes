class Solution {
    boolean isPossibleToAddStation(int stations[], double penalty, int k) {

        int numberOfStations = stations.length;
        int noOfStationsAdded = 0;
        for (int i = 0; i < numberOfStations - 1; i++) {
            double additionalStations = (stations[i+1]-stations[i])/penalty;
            noOfStationsAdded += (int)Math.ceil(additionalStations)- 1;
        }
      
        return noOfStationsAdded <= k;
    }

    public double minmaxGasDist(int[] stations, int k) {
        int maxDif = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            maxDif = Math.max(maxDif, stations[i + 1] - stations[i]);
        }

        double left = 0;
        double right = maxDif;
        double ans = right;

        double accuracy = (double) (1e-6);

        while (right - left >= accuracy) {
            double mid = (left + right) / 2;
            if (isPossibleToAddStation(stations, mid, k)) {
                right = mid - accuracy;
                ans = mid;
            } else
                left = mid + accuracy;
        }

        return ans;

    }
}