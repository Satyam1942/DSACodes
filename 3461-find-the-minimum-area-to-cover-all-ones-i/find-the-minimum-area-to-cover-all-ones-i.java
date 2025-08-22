class Solution {
    public int minimumArea(int[][] grid) {
       int leftCol = Integer.MAX_VALUE;
       int rightCol = Integer.MIN_VALUE;
       int topRow = Integer.MAX_VALUE;
       int bottomRow = Integer.MIN_VALUE;
       int length =grid.length;
       int width = grid[0].length;
       for(int i=0; i<length; i++) {
        for(int j=0; j<width; j++) {
            if(grid[i][j] == 1) {
                if(j<=leftCol) {
                    leftCol = j;
                }
                if(i<=topRow) {
                    topRow = i;
                }
                if(j>=rightCol) {
                    rightCol = j;
                }
                if(i>=bottomRow) {
                    bottomRow = i;
                }
            }
        }
       }

       int area = (bottomRow-topRow+1)*(rightCol-leftCol+1);
       return  area;
    }
}