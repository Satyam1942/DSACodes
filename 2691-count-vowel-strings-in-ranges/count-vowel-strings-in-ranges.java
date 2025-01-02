class Solution {
    boolean isVowel(char token) {
        if(token=='a' || token=='e' || token =='i' || token == 'o' || token=='u') {
            return true;
        }
        return false;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int length = words.length;
        int vowelCount[] = new int[length];
        int numberOfQueries = queries.length;
        int vowelCountRange[] = new int[numberOfQueries];

        for(int i=0;i<length;i++) {
            int wordLength = words[i].length();
            char firstCharacter = words[i].charAt(0);
            char lastCharacter = words[i].charAt(wordLength-1);
            if(isVowel(firstCharacter) && isVowel(lastCharacter)) {
                vowelCount[i] = (i==0)? 1 : vowelCount[i-1]+1;
            } else {
                vowelCount[i] =  (i==0)? 0 : vowelCount[i-1];
            }
        }

        for(int i=0;i<numberOfQueries;i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            vowelCountRange[i] = (l==0)? vowelCount[r] : vowelCount[r]-vowelCount[l-1];
        }

        return vowelCountRange;
    }
}