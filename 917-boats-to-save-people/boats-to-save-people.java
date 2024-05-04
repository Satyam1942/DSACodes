class Solution {
    public int numRescueBoats(int[] weight, int limit) {
        Arrays.sort(weight);
        int length = weight.length;
        int i = 0, j = length - 1;
        int boatsRequired = 0;
        while (i <= j) {
            boatsRequired++;
            if (weight[i] + weight[j] <= limit)
                i++;
            j--;
        }
        return boatsRequired;

    }
}