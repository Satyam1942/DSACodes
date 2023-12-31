class Solution {
    public int characterReplacement(String s, int k) {
        int length = s.length();
        int longestSubstring = 0;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            int left = 0, right = 0;
            int temp = k;
            int maxLength = 0;

            while (right <= length) {
                if (temp < 0) {
                    maxLength = Math.max(right - left - 1, maxLength);
                    if (s.charAt(left) != ch) temp++;
                    left++;
                    continue;
                }
                if (right == length)  maxLength = Math.max(right - left, maxLength);
                if (right < length && s.charAt(right) != ch) temp--;
                right++;
            }
            longestSubstring = Math.max(longestSubstring, maxLength);
        }

        return longestSubstring;

    }
}