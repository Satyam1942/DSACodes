class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int numberOfWords = words1.length;
        int freq[][] = new int[numberOfWords][26];

        for(int i=0;i<numberOfWords;i++) {
            String  word = words1[i];
            for(int j=0;j<word.length();j++) {
                char token = word.charAt(j);
                freq[i][(int)token-97]++;
            }
        }

        int commonFreq[] = new int[26];
        for(int i=0;i<words2.length;i++) {
            String word = words2[i];
            int temp[] = new int[26];
            for(int j=0;j<word.length();j++) {
                char token = word.charAt(j);
                temp[(int)token-97]++;
            }
            for(int j=0;j<26;j++) {
                commonFreq[j] = Math.max(commonFreq[j], temp[j]);
            }
        }

        List<String> universalStrings = new ArrayList<>();

        for(int i=0;i<numberOfWords;i++) {
            boolean flag = true;
            for(int j=0;j<26;j++) {
                if(freq[i][j]<commonFreq[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                universalStrings.add(words1[i]);
            }
        }

        return universalStrings;
    }
}