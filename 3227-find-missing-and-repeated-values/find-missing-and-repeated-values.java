class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int noOfRows = grid.length;
        int noOfCols = grid[0].length;
        int xor = 0;

        for(int i=0; i<noOfRows; i++) {
            for(int j=0; j<noOfCols; j++) {
                xor^=grid[i][j];
            }
        }

        for(int i=1; i<=noOfRows*noOfCols; i++) {
            xor^=i;
        }

       
        int leastSignificantSetBit = 0;
        for(int i=0; i<32; i++) {
            if((xor&(1<<i))>0) {
                leastSignificantSetBit = i;
                break;
            }
        }

        int set1 = 0;
        int set2 = 0;
        for(int i=1; i<=noOfRows*noOfCols; i++) {
            if((i&(1<<leastSignificantSetBit))>0) {
                set1^=i;
            } else {
                set2^=i;
            }
        }

        for(int i=0; i<noOfRows; i++) {
            for(int j=0; j<noOfCols; j++) {
                if((grid[i][j]&(1<<leastSignificantSetBit))>0) {
                    set1^=grid[i][j];
                } else {
                    set2^=grid[i][j];
                }
            }
        }

     
        int repeated = 0;
        int missing = 0;
        
        for(int i=0; i<noOfRows; i++) {
            for(int j=0; j<noOfCols; j++) {
                if(grid[i][j]==set1) {
                   repeated = set1;
                    missing = set2;
                } else if(grid[i][j]==set2){
                    repeated = set2;
                    missing = set1;
                }
            }
        }

        return new int[]{repeated, missing};
    }   
}