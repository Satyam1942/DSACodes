class Solution {
    int recursion(int i, int j, int grid[][], int k, Integer cache[][][]) {
        int length = grid.length;
        int width = grid[0].length;
        
        if(i==length-1 && j==width-1) {
            if(grid[i][j]==0) {
                return 0;
            } else {
                if(k==0) {
                    return Integer.MIN_VALUE;
                } else {
                    return grid[i][j];
                }
            }
        }

        if(cache[i][j][k] != null) {
            return cache[i][j][k];
        }

        int right = Integer.MIN_VALUE;
        int down = Integer.MIN_VALUE;
        int score = grid[i][j];
        int deltaK = (score == 0)? 0 : 1;

        if(i+1<length && k-deltaK>=0) {
            down = recursion(i+1, j, grid, k-deltaK, cache);
        } 
        if(j+1<width && k-deltaK>=0) {
            right = recursion(i, j+1, grid, k-deltaK, cache);
        }

        int finalScore =  Math.max(down, right);
        if(finalScore != Integer.MIN_VALUE) {
            finalScore+=score;
        }

        return cache[i][j][k] = finalScore;
    }

    public int maxPathScore(int[][] grid, int k) {
        int length = grid.length;
        int width = grid[0].length;
        Integer cache[][][] = new Integer[length][width][k+1];

        int maxScore =  recursion(0, 0, grid, k, cache);
        if(maxScore == Integer.MIN_VALUE) {
            return -1;
        } else {
            return maxScore;
        }
    }
}