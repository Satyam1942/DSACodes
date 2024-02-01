class Solution {
    int maxStone(int index, int stoneValue[], Integer cache[]) {
        if (index == stoneValue.length)
            return 0;
        if (cache[index] != null)
            return cache[index];

        int maxScore = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = index; i <= Math.min(stoneValue.length - 1, index + 2); i++) {
            sum += stoneValue[i];
            int tempScore = sum - maxStone(i + 1, stoneValue, cache);
            maxScore = Math.max(maxScore, tempScore);
        }
        return cache[index] = maxScore;
    }

    public String stoneGameIII(int[] stoneValue) {
        Integer cache[] = new Integer[stoneValue.length];
        int score = maxStone(0, stoneValue, cache);

        if (score > 0)
            return "Alice";
        else if (score < 0)
            return "Bob";
        else
            return "Tie";
    }
}