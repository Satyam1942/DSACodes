class Solution {
    private Long[][] dp;
    private String suffix;
    private int limit;

    public long numberOfPowerfulInt(long start, long finish, int limit, String suffix) {
        this.limit = limit;
        this.suffix = suffix;

        long countToFinish = countValid(finish);
        long countToStart = countValid(start - 1);
        return countToFinish - countToStart;
    }

    private long countValid(long num) {
        if (num < Long.parseLong(suffix)) return 0;
        String numStr = Long.toString(num);
        dp = new Long[numStr.length()][2];
        return dfs(0, true, numStr);
    }

    private long dfs(int idx, boolean tight, String num) {
        if (idx == num.length()) return 1L;
        if (dp[idx][tight ? 1 : 0] != null) return dp[idx][tight ? 1 : 0];

        long res = 0;
        int maxDigit = tight ? num.charAt(idx) - '0' : 9;

        int suffixStart = num.length() - suffix.length();
        if (idx >= suffixStart) {
            int suffixIdx = idx - suffixStart;
            int digit = suffix.charAt(suffixIdx) - '0';
            if (digit <= maxDigit && digit <= limit)
                res += dfs(idx + 1, tight && digit == maxDigit, num);
        } else {
            for (int d = 0; d <= Math.min(maxDigit, limit); d++) {
                res += dfs(idx + 1, tight && d == maxDigit, num);
            }
        }
        return dp[idx][tight ? 1 : 0] = res;
    }
}