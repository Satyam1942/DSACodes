class Solution {
    boolean rec(int index1, int index2, int isNotMatching, int canNotMatch, String words1[], String words2[], Boolean cache[][][][]) {
        if(index1 == words1.length) {
            return index2==words2.length;
        }

        if(index2==words2.length) {
            if(canNotMatch==0) {
                return false;
            } else {
                return true;
            }
        }

        if(cache[index1][index2][isNotMatching][canNotMatch] != null){
            return cache[index1][index2][isNotMatching][canNotMatch];
        }

        boolean match = false;
        boolean notMatch = false;

        if(canNotMatch==1 || isNotMatching == 1) {
            notMatch = rec(index1+1,index2,1,0,words1,words2,cache);
        }

        if(words1[index1].equals(words2[index2])) {
            match = rec(index1+1, index2+1, 0, canNotMatch, words1, words2,cache);
        }

        return cache[index1][index2][isNotMatching][canNotMatch] = match||notMatch;
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence2.length()>sentence1.length()) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        String words1[] = sentence1.split(" ");
        String words2[] = sentence2.split(" ");
        int length1 = words1.length;
        int length2 = words2.length;

        Boolean cache[][][][] = new Boolean[length1][length2][2][2]; 
        return rec(0,0,0,1,words1,words2,cache);
        
    }
}