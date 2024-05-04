class Solution {
    boolean isPossible(int boatsAvailable, int weight[], int limit) {
        int length = weight.length;
        int i = 0, j = length - 1;
        int boatsRequired = 0;
        while (i <= j) {
            boatsRequired++;
            if (weight[i] + weight[j] <= limit)
                i++;
            j--;
        }
        return boatsAvailable >= boatsRequired;
    }

    public int numRescueBoats(int[] weight, int limit) {
        Arrays.sort(weight);
        int noOfPeople = weight.length;
        int left = 1;
        int right = noOfPeople;
        int minBoats = noOfPeople;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid, weight, limit)) {
                right = mid - 1;
                minBoats = mid;
            } else
                left = mid + 1;
        }
        return minBoats;

    }
}