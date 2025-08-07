class Solution {
    int getPlayer2Score(int row, int col, int fruits[][], Integer cache[][]) {
        int length = fruits.length;
        if(row==length-1) {
            if(col!=length-1) {
                return Integer.MIN_VALUE;
            } else {
                return 0;
            }
        }
        if(cache[row][col] !=null) {
            return cache[row][col];
        }

        int straight = getPlayer2Score(row+1, col, fruits, cache);
        int diagonalRight = 0;
        int diagonalLeft = 0;
        if(col+1<length) {
            diagonalRight = getPlayer2Score(row+1, col+1, fruits, cache);
        }
        if(col-1>=0) {
            diagonalLeft = getPlayer2Score(row+1, col-1, fruits, cache);
        }
        int score = fruits[row][col] + Math.max(straight, Math.max(diagonalLeft, diagonalRight));
        return cache[row][col] = score;
    }

    int getPlayer3Score(int row, int col, int fruits[][], Integer cache[][]) {
        int length = fruits.length;
        if(col==length-1) {
            if(row!=length-1) {
                return Integer.MIN_VALUE;
            } else {
                return 0;
            }
        }
         if(cache[row][col] !=null) {
            return cache[row][col];
        }
        
        int straight = getPlayer3Score(row, col+1, fruits, cache);
        int diagonalUp = 0;
        int diagonalDown = 0;
        if(row+1<length) {
            diagonalDown = getPlayer3Score(row+1, col+1, fruits, cache);
        }
        if(row-1>=0) {
            diagonalUp = getPlayer3Score(row-1, col+1, fruits, cache);
        }
        int score = fruits[row][col] + Math.max(straight, Math.max(diagonalDown, diagonalUp));
        return cache[row][col] = score;
    }

    public int maxCollectedFruits(int[][] fruits) {
        int length = fruits.length;
        int player1Score = 0;
        int player2Score = 0;
        int player3Score = 0;
        for(int i=0; i<length; i++) {
            player1Score+=fruits[i][i];
            fruits[i][i] = 0;
        }
        Integer cache[][] = new Integer[length][length];
        player2Score = getPlayer2Score(0, length-1, fruits, cache);
        cache = new Integer[length][length];
        player3Score = getPlayer3Score(length-1, 0, fruits, cache);
        int totalScore = player1Score + player2Score + player3Score;
        return totalScore;
    }
}
/*

*/