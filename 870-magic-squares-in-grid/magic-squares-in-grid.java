class Solution {
    int magicSum = 15;
    boolean isMagicSquare(int grid[][], int startRow, int startCol){
        //checking if all numbers are in range of 1 to 9
        HashSet<Integer> set = new HashSet<>();
        for(int i=startRow;i<=startRow+2;i++){
            int sumRow = 0;
            for(int j=startCol;j<=startCol+2;j++){
                if(grid[i][j]>9 || grid[i][j]<1)
                    return false;
                else
                    set.add(grid[i][j]);
            }
        }
        if(set.size()!=9)
            return false;
      
        //checking sum of each row
        for(int i=startRow;i<=startRow+2;i++){
            int sumRow = 0;
            for(int j=startCol;j<=startCol+2;j++){
                sumRow+=grid[i][j];
            }
            if(sumRow!=magicSum)
                return false;
        }


         //checking sum of each col
        for(int i=startCol;i<=startCol+2;i++){
            int sumCol = 0;
            for(int j=startRow;j<=startRow+2;j++){
                sumCol+=grid[j][i];
            }
            if(sumCol!=magicSum)
                return false;
        }

        //checking sum of left diagonal 
        int sumLeftDiagonal = 0;
        for(int i=0;i<=2;i++){
            sumLeftDiagonal+= grid[startRow+i][startCol+i];
        }
    
        if(sumLeftDiagonal!=magicSum)
            return false;

    
        //checking sum of right diagonal 
        int sumRightDiagonal = 0;
        for(int i=0;i<=2;i++){
            sumRightDiagonal+= grid[startRow+i][startCol+(2-i)];
        }
        if(sumRightDiagonal!=magicSum)
            return false;

        return true;
    }


    public int numMagicSquaresInside(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        int count = 0;

        for(int i=0;i<length;i++){
            for(int j=0;j<width;j++){
                int startRow = i;
                int startCol = j;
                if(i+2<length && j+2<width){
                    if(isMagicSquare(grid,startRow,startCol))
                        count++;
                }
            }
        }

        return count;
    }
}