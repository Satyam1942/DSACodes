class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int length = grid.length;
        int width = grid[0].length;
        Integer cache[][][] = new Integer[length][width][k+1];

        for(int i=0;i<=k;i++) {
            if(grid[length-1][width-1]==0) {
                cache[length-1][width-1][i] =  0;
            } else {
                if(i==0) {
                    cache[length-1][width-1][i] = Integer.MIN_VALUE;
                } else {
                    cache[length-1][width-1][i] = grid[length-1][width-1];
                }
            }            
        }

        for(int i = length-1; i>=0; i--) {
            for(int j=width-1;j>=0; j--) {
                if(i==length-1 && j==width-1) {
                    continue;
                }
                for(int l=0; l<=k; l++) {
                    int right = Integer.MIN_VALUE;
                    int down = Integer.MIN_VALUE;
                    int score = grid[i][j];
                    int deltaK = (score == 0)? 0 : 1;

                    if(i+1<length && l-deltaK>=0) {
                        down = cache[i+1][j][l-deltaK];
                    }            
                    if(j+1<width && l-deltaK>=0) {
                        right = cache[i][j+1][l-deltaK];
                    }

                    int finalScore =  Math.max(down, right);
                    if(finalScore != Integer.MIN_VALUE) {
                        finalScore+=score;
                    }
                    
                    cache[i][j][l] = finalScore;
                }
            }
        }

        int maxScore = cache[0][0][k];

        if(maxScore == Integer.MIN_VALUE) {
            return -1;
        } else {
            return maxScore;
        }

    }
}