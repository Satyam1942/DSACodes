class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        List<int[]> grumpyIndices = new ArrayList<>();
        int length = customers.length;
        int nonGrumpySum = 0;

        for (int i = 0; i < length; i++) {
            if (grumpy[i] == 0) {
                nonGrumpySum += customers[i];
            } else {
                grumpyIndices.add(new int[] { customers[i], i });
            }
        }

        int maxCustomerSum = 0;
        int runningCustomerSum = 0;

        int left = 0;
        int right = 0;
        length = grumpyIndices.size();

        while (left <= right && right <= length) {
            
            if (right < length &&
                    grumpyIndices.get(right)[1] - grumpyIndices.get(left)[1] >= minutes) {
                runningCustomerSum -= grumpyIndices.get(left)[0];
                left++;
                continue;
            }

            if (right < length) {
                runningCustomerSum += grumpyIndices.get(right)[0];
                maxCustomerSum = Math.max(maxCustomerSum, runningCustomerSum);
            }

            right++;
        }

        int maxCustomerSatisfaction = maxCustomerSum + nonGrumpySum;
        return maxCustomerSatisfaction;

    }
}