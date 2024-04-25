class Solution {

    int longestIdealSubsequence(int index, int prevChar, int k, String s, Integer cache[][]) {
        if (index == s.length())
            return 0;
        if (cache[index][prevChar] != null)
            return cache[index][prevChar];

        int notTake = longestIdealSubsequence(index + 1, prevChar, k, s, cache);
        int curChar = (int) s.charAt(index) - 97;
        int difference = Math.abs(prevChar - curChar);
        int take = Integer.MIN_VALUE;

        if (prevChar == 26 || difference <= k)
            take = 1 + longestIdealSubsequence(index + 1, curChar, k, s, cache);

        return cache[index][prevChar] = Math.max(take, notTake);

    }

    public int longestIdealString(String s, int k) {
        int length = s.length();
        Integer cache[][] = new Integer[length][27];
        return longestIdealSubsequence(0,26,k,s,cache);
    }
}