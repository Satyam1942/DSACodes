class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int length = fruits.length;
        int leftMostPos = Math.min(startPos, fruits[0][0]);
        int rightMostPos = Math.max(fruits[length-1][0], startPos);
        int fruitVal[] = new int[rightMostPos+1];
        long prefixSum[] = new long[rightMostPos+1];

        for(int i=0; i<length; i++) {
            fruitVal[fruits[i][0]] = fruits[i][1];
        }

        prefixSum[startPos] = fruitVal[startPos]; 
        for(int i= startPos+1; i<=rightMostPos; i++) {
            prefixSum[i] = prefixSum[i-1] + fruitVal[i];
        }

        for(int i= startPos-1; i>=leftMostPos; i--) {
            prefixSum[i] = prefixSum[i+1] + fruitVal[i];
        }

        long maxScore = prefixSum[startPos];
        for(int i = startPos+1; i<=Math.min(startPos+k,rightMostPos); i++) {
            long straightScore = prefixSum[i];
            int reachableIndex = Math.max(startPos - Math.max((k-(i-startPos))/2, 0), leftMostPos);
            long turnAroundScore = prefixSum[i] + prefixSum[reachableIndex] - prefixSum[startPos];
            long finalScore = Math.max(straightScore, turnAroundScore);
            maxScore = Math.max(maxScore, finalScore);
        }

        for(int i = startPos-1; i>=Math.max(startPos-k, leftMostPos); i--) {
            long straightScore = prefixSum[i];
            int reachableIndex = Math.min(startPos + Math.max((k-(startPos-i))/2, 0), rightMostPos);
            long turnAroundScore = prefixSum[i] + prefixSum[reachableIndex] - prefixSum[startPos];
            long finalScore = Math.max(straightScore, turnAroundScore);
            maxScore = Math.max(maxScore, finalScore);
        }

        return (int)maxScore;
    }
}