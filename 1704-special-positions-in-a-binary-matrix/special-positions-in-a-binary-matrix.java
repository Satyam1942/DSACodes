class Solution {
    public int numSpecial(int[][] mat) {
        int noOfRows = mat.length;
        int noOfCols = mat[0].length;
        int specialPosCount = 0;
        HashSet<Integer> specialCols = new HashSet<Integer>();
        
        for(int i=0; i<noOfRows; i++) {
            int count = 0;
            int curCol = 0;
            for(int j=0; j<noOfCols; j++) {
                if(mat[i][j]==1) {
                    count++;
                    curCol = j;
                }
            }
            if(count==1) {
                specialCols.add(curCol);
            }
        }

        for(int col: specialCols) {
            int count = 0;
            for(int i=0; i<noOfRows; i++) {
                if(mat[i][col]==1) {
                    count++;
                }
            }
            if(count==1) {
                specialPosCount++;
            }
        }

        return specialPosCount;
    }
}