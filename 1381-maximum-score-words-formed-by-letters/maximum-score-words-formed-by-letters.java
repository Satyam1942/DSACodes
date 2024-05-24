class Solution {
    boolean canForm(String word, int freq[]){
        int length = word.length();
        int freqOfCharacterInWord[] = new int[26];
        for(int i=0;i<length;i++){
            char token = word.charAt(i);
            freqOfCharacterInWord[(int)token-97]++;
        }

        for(int i=0;i<26;i++){
            if(freq[i]<freqOfCharacterInWord[i])
                return false;
        }
        return true;
    }

    int calculateScore(String word, int score[]){
        int length = word.length();
        int totalScore = 0;
        for(int i=0;i<length;i++){
            char token = word.charAt(i);
            totalScore+=score[(int)token-97];
        }
        return totalScore;
    }

    void updateFreqArray(String word, int freq[]){
        int length = word.length();
       
        for(int i=0;i<length;i++){
            char token = word.charAt(i);
            freq[(int)token-97]--;
        }
    }

    void deupdateFreqArray(String word, int freq[]){
        int length = word.length();
       
        for(int i=0;i<length;i++){
            char token = word.charAt(i);
            freq[(int)token-97]++;
        }
    }
    int maxScore(int index, String words[], int freq[] , int score[]){
        if(index==words.length)
            return 0;

        int notForm = maxScore(index+1,words,freq,score);
        int form = 0;
        if(canForm(words[index],freq)){
            updateFreqArray(words[index],freq);
            form = calculateScore(words[index],score) + maxScore(index+1,words,freq,score);
            deupdateFreqArray(words[index],freq);
        }

        return Math.max(form,notForm);
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int freq[] = new int[26];
        for(int i=0;i<letters.length;i++){
            char token = letters[i];
            freq[(int)token-97]++;
        }

        return maxScore(0,words,freq,score);
    }
}