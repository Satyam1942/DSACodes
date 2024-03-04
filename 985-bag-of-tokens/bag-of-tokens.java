class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int noOfTokens = tokens.length;
        //Important missed edge case
        if(noOfTokens==0)
            return 0;
        Arrays.sort(tokens);

        int leftPointer = 1;
        int rightPointer = noOfTokens - 1;
        int score = 0;

        // checking for first case
        if (power >= tokens[0]) {
            score++;
            power -= tokens[0];
        } else {
            return 0;
        }

        int maxScore = score;
        while (leftPointer < rightPointer) {
            if (power >= tokens[leftPointer]) {
                score++;
                power -= tokens[leftPointer];
                leftPointer++;
            } else {
                if (score == 0)
                    return maxScore;
                score--;
                power += tokens[rightPointer];
                rightPointer--;
            }
            maxScore = Math.max(maxScore, score);
        }

        if (leftPointer == rightPointer && power >= tokens[leftPointer])
            score++;

         maxScore = Math.max(maxScore, score);
        return maxScore;

    }
}