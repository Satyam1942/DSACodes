class Solution {
    public long mostPoints(int[][] questions) {
        int noOfQuestions = questions.length;
        Long cache[] = new Long[noOfQuestions+1];
        cache[noOfQuestions] = 0l;
        for(int index = noOfQuestions-1; index>=0 ; index--) {
            long notSolve = cache[index+1];
            int nextIndex = Math.min(index+questions[index][1]+1, noOfQuestions);
            long solve = questions[index][0] + cache[nextIndex];
            cache[index] = Math.max(solve, notSolve);
        }

        return cache[0];
    }
}