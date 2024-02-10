class Solution {

    void computeOddLengthPalindromes(String s, int count[]) {
        int length = s.length();
        for (int center = 0; center < length; center++) {
            int left = center;
            int right = center;
            while (left >= 0 && right < length) {
                if (s.charAt(left) == s.charAt(right))
                    count[0]++;
                else
                    break;
                left--;
                right++;
            }
        }
    }

    void computeEvenLengthPalindromes(String s, int count[]) {
        int length = s.length();
        for (int center = 0; center < length - 1; center++) {
            int left = center;
            int right = center + 1;
            while (left >= 0 && right < length) {
                if (s.charAt(left) == s.charAt(right))
                    count[0]++;
                else
                    break;
                left--;
                right++;
            }
        }
    }

    public int countSubstrings(String s) {
        int length = s.length();
        int count[] = new int[1];

        computeOddLengthPalindromes(s, count);
        computeEvenLengthPalindromes(s, count);

        return count[0];

    }
}