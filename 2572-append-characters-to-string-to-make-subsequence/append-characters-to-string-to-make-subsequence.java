class Solution {
    public int appendCharacters(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        int i = 0, j = 0;

        while (i < lengthS && j < lengthT) {
            char sToken = s.charAt(i);
            char tToken = t.charAt(j);
            if (sToken == tToken)
                j++;
            i++;
        }

        return lengthT - j;

    }
}