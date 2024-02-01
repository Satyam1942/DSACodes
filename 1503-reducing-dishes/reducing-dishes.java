class Solution {
    int maxCoefficient(int index, int prevCooked, int satisfaction[], Integer cache[][]) {

        if (index == satisfaction.length)
            return 0;
        if (cache[index][prevCooked] != null)
            return cache[index][prevCooked];

        int notTake = maxCoefficient(index + 1, prevCooked, satisfaction, cache);
        int take = satisfaction[index] * (prevCooked + 1) +
                maxCoefficient(index + 1, prevCooked + 1, satisfaction, cache);

        return cache[index][prevCooked] = Math.max(take, notTake);
    }

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        Integer cache[][] = new Integer [satisfaction.length][satisfaction.length+1];
        return maxCoefficient(0,0,satisfaction,cache);
    }
}