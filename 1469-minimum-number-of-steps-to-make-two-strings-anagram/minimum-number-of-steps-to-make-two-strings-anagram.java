class Solution {
    public int minSteps(String s, String t) {
        int freq[] = new int[26];
        int length = s.length();
        int noOfReplacements = 0;
        for (int i = 0; i < length; i++) {
            char ch = t.charAt(i);
            int index = (int) ch - 97;
            freq[index]++;
        }
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            int index = (int) ch - 97;
            if (freq[index] == 0)
                noOfReplacements++;
            else
                freq[index]--;
        }
        return  noOfReplacements;

    }
}