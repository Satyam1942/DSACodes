class Solution {

    void computeOddLengthPalindromes(String s, int cache[][]) {
        int length = s.length();
        for (int center = 0; center < length; center++) {
            int left = center;
            int right = center;
            while (left >= 0 && right < length) {
                if (s.charAt(left) == s.charAt(right))
                    cache[left][right]++;
                else
                    break;
                left--;
                right++;
            }
        }
    }

    void computeEvenLengthPalindromes(String s, int cache[][]) {
        int length = s.length();
        for (int center = 0; center < length - 1; center++) {
            int left = center;
            int right = center + 1;
            while (left >= 0 && right < length) {
                if (s.charAt(left) == s.charAt(right))
                    cache[left][right]++;
                else
                    break;
                left--;
                right++;
            }
        }
    }

    public int countSubstrings(String s) {
        int length = s.length();
        int cache[][] = new int[length][length];

        computeOddLengthPalindromes(s, cache);
        computeEvenLengthPalindromes(s, cache);

        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                count += cache[i][j];
            }
        }

        return count;

    }
}