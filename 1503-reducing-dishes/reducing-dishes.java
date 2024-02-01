class Solution {

    public int maxSatisfaction(int[] satisfaction) {
        int length = satisfaction.length;
        Arrays.sort(satisfaction);
        Integer suffixSum[] = new Integer[length];

        int sum = 0;
        for (int i = 0; i < length; i++)
            sum += satisfaction[i];

        int prevLikeCoefficient = 0;

        for (int i = 0; i < length; i++) {
            suffixSum[i] = sum;
            sum -= satisfaction[i];
            prevLikeCoefficient += satisfaction[i] * (i + 1);
        }

        int maxLikeCoefficient = Math.max(0,prevLikeCoefficient);

        for (int i = 1; i < length; i++) {
            int curLikeCoefficient = prevLikeCoefficient - suffixSum[i - 1];
            maxLikeCoefficient = Math.max(maxLikeCoefficient,
                    curLikeCoefficient);

            prevLikeCoefficient = curLikeCoefficient;
        }

        return maxLikeCoefficient;

    }
}