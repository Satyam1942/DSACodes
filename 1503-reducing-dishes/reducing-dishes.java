class Solution {

    public int maxSatisfaction(int[] satisfaction) {
        int length = satisfaction.length;
        Arrays.sort(satisfaction);

        int sum = 0;
        int prevLikeCoefficient = 0;
        for (int i = 0; i < length; i++){
            sum += satisfaction[i];
            prevLikeCoefficient += satisfaction[i] * (i + 1);
        }

        int maxLikeCoefficient = Math.max(0,prevLikeCoefficient);

        for (int i = 1; i < length; i++) {
            int curLikeCoefficient = prevLikeCoefficient - sum;
            maxLikeCoefficient = Math.max(maxLikeCoefficient,
                    curLikeCoefficient);
            sum-=satisfaction[i-1];
            prevLikeCoefficient = curLikeCoefficient;
        }

        return maxLikeCoefficient;

    }
}