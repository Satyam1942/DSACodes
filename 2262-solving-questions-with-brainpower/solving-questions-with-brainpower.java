class Solution {
    long getPoints(int index, int [][] questions, Long cache[]) {
        if(index >= questions.length) {
            return 0l;
        }

        if(cache[index]!=null) {
            return cache[index];
        }

        long notSolve = getPoints(index+1, questions, cache);
        long solve = questions[index][0] + getPoints(index+questions[index][1]+1, questions, cache);
        return cache[index] = Math.max(solve, notSolve);
    }

    public long mostPoints(int[][] questions) {
        int noOfQuestions = questions.length;
        Long cache[] = new Long[noOfQuestions];
        return getPoints(0, questions, cache);
    }
}