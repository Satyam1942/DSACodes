class Solution {
    long mod = (long) (1e9 + 7);

    long rec(int n, int a, int l, Long cache[][][]) {

        if (a == 2)
            return 0l;
        if (l == 3)
            return 0l;
        if (n == 0)
            return 1l;

        if (cache[n][a][l] != null)
            return cache[n][a][l];

        long present = rec(n - 1, a, 0, cache);
        long absent = rec(n - 1, a + 1, 0, cache);
        long late = rec(n - 1, a, l + 1, cache);

        return cache[n][a][l] = (present + absent + late) % mod;
    }

    public int checkRecord(int n) {
        Long cache[][][] = new Long[n + 1][3][4];
        long res = rec(n, 0, 0, cache);
        return (int) (res % mod);

    }
}