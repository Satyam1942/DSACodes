class Solution {
    long mod = (long) (1e9 + 7);

    long rec(int row, int col, int noOfMoves, Long cache[][][], int maxMoves,int m,int n) {

        if (noOfMoves == maxMoves)
            return 0;

        if (cache[row][col][noOfMoves] != null)
            return cache[row][col][noOfMoves];

        int delRow[] = { 0, 1, -1, 0 };
        int delCol[] = { -1, 0, 0, 1 };

        long res = 0;
        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];
            boolean isValid = newRow >= 0 && newCol >= 0 && newRow < m && newCol < n;

            if (isValid)
                res += rec(newRow, newCol, noOfMoves + 1, cache,maxMoves,m,n);
            else
                res += 1;
        }

        return cache[row][col][noOfMoves] = res % mod;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Long dp[][][] = new Long[m][n][maxMove + 1];
        return (int)rec(startRow, startColumn,0, dp, maxMove,m,n);
    }
}