class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int left = 0, right = 0;
        int maxLength = 0;

        while (right <= length) {
            if (maxCost < 0) {
                maxLength = Math.max(maxLength, right - left - 1);
                int prevCost = Math.abs((int) s.charAt(left) - (int) t.charAt(left));
                maxCost += prevCost;
                left++;
                continue;
            }

            if (right < length) {
                int curCost = Math.abs((int) s.charAt(right) - (int) t.charAt(right));
                maxCost -= curCost;
            }
            right++;
        }

        maxLength = Math.max(maxLength, right - left - 1);
        return maxLength;

    }
}