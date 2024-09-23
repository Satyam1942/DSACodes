class Solution {
    void computeFrequency(int freq[] , String word) {
        int length = word.length();
        for(int i=0;i<length;i++) {
            char token = word.charAt(i);
            freq[(int)token-97]++;
        }
    }

    boolean doesMatch(int freq1[] , int freq2[]) {
        for(int i=0;i<26;i++) {
            if(freq1[i]<freq2[i]) {
                return false;
            }
        }
        return true;
    }

    public long validSubstringCount(String word1, String word2) {
        int frequencyWord1[] = new int[26];
        int frequencyWord2[] = new int[26];
        int length1 = word1.length();
        int length2 = word2.length();

        computeFrequency(frequencyWord2,word2);
       
        int left=0;
        int right=0;
        long substringCount = 0;

        while(right<=length1) {
            if(doesMatch(frequencyWord1,frequencyWord2)) {
                substringCount += length1-right+1;
                char prev = word1.charAt(left);
                frequencyWord1[(int)prev-97]--;
                left++;
                continue;
            }
            if(right<length1) {
                char newToken = word1.charAt(right);
                frequencyWord1[(int)newToken-97]++;
            }
            right++;
        }

        return substringCount;
    }
}