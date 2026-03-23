class Solution {
    long mod = (long)(1e9+7);
    Long[] recursion(int i, int j, int[][] grid, Long cache[][][]) {
        int curElement = grid[i][j];
        long mini = Long.MAX_VALUE;
        long maxi = Long.MIN_VALUE;

        if(cache[i][j][0]!=null ){
            return cache[i][j];
        }

        if (j + 1 < grid[0].length) {
            Long right[] = recursion(i, j + 1, grid, cache);
            for (int k = 0; k < 2; k++) {
                mini = Math.min(mini, right[k]);
                maxi = Math.max(maxi, right[k]);
            }
        }
        if (i + 1 < grid.length) {
            Long left[] = recursion(i + 1, j, grid, cache);
            for (int k = 0; k < 2; k++) {
                mini = Math.min(mini, left[k]);
                maxi = Math.max(maxi, left[k]);
            }
        }

        if (i+1 == grid.length && j+1 == grid[0].length) {
            mini = 1;
            maxi = 1;
        }

        if (mini != Long.MAX_VALUE) {
            mini = (mini * curElement);
        }

        if (maxi != Integer.MIN_VALUE) {
            maxi = (maxi * curElement);
        }
        Long temp[] = new Long[] { mini, maxi};
        return cache[i][j] = temp;
    }

    public int maxProductPath(int[][] grid) {
        Long cache[][][] =new Long [grid.length][grid[0].length][2];
        Long temp[] = recursion(0, 0, grid, cache);
        long ans = Math.max(temp[0], temp[1])%mod;
        return (ans < 0) ? -1 : (int)ans;
    }
}