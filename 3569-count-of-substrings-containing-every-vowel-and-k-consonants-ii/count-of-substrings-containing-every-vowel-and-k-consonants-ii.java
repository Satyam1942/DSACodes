class Solution {
    boolean isVowel(char token) {
        return token=='a' || token == 'e' || token=='i' || token =='o' || token=='u';
    }

    public long countOfSubstrings(String word, int k) {
        int length = word.length();
        HashMap<Character, Integer> vowels = new HashMap<>();
        TreeSet<Integer> consonantIndices = new TreeSet<>();
        for(int l=0; l<length; l++) {
            char token = word.charAt(l);
            if(!isVowel(token)) {
                consonantIndices.add(l);
            }
        }
        
        int i = 0;
        int j = 0;
        int consonants = 0;
        int lastConsonantIndex = 0;
        long substrCount = 0;

        while(j<=length) {
            if(consonants >= k && vowels.size()==5) {
                Integer nextIndex = consonantIndices.higher( lastConsonantIndex );
                if(nextIndex==null) {
                    nextIndex = length;
                }

                if(consonants == k) {
                    substrCount+= nextIndex-j+1;
                }
                
                char prevToken = word.charAt(i);
                if(isVowel(prevToken)) {
                    int freq = vowels.get(prevToken);
                    if(freq == 1) {
                        vowels.remove(prevToken);
                    } else {
                        vowels.put(prevToken, freq-1);
                    }
                } else {
                    consonants--;
                }
                i++;
                continue;
            }

            if(j<length) {
                char token = word.charAt(j);
                if(isVowel(token)) {
                    int freq = vowels.getOrDefault(token, 0);
                    vowels.put(token, freq+1);
                } else {
                    consonants++;
                    lastConsonantIndex = j;
                }
            }
            j++;
        }

        return substrCount;         
    }
}

/*
    aeiaoule
    2+2+1+
*/