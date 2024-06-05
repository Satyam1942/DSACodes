class Solution {
    public List<String> commonChars(String[] words) {
        int length = words.length;
        int freqList[][] = new int[length][26];
        for(int i=0;i<length;i++){
           String word  = words[i];
           for(int j=0;j<word.length();j++){
                char token = word.charAt(j);
                freqList[i][(int)token-97]++;
           }
        }

        List<String> list = new ArrayList<>();
        for(int i=0;i<26;i++){
            int minFreq = Integer.MAX_VALUE;
            for(int j=0;j<length;j++){
                minFreq = Math.min(minFreq,freqList[j][i]);
            }
            for(int j=0;j<minFreq;j++){
                char token = (char)(i+97);
                list.add(String.valueOf(token));
            }
        }

        return list;
    }
}