class Solution {
    void addWordsToSet(String[] dictionary, HashSet<String> dictionarySet){
        for(String word : dictionary) {
            dictionarySet.add(word);
        }
    }

    int partitionString(int i, String word, HashSet<String> dictionarySet, Integer cache[]) {
        
        if(i==word.length())
            return 0;

        if(cache[i]!=null)
            return cache[i];

        int notUse = 1+partitionString(i+1, word, dictionarySet, cache);
        int use = Integer.MAX_VALUE;

        for(int k=i; k<word.length(); k++) {
            String subWord = word.substring(i,k+1);
            if(dictionarySet.contains(subWord)) {
                int temp = partitionString(k+1, word, dictionarySet, cache);
                use = Math.min(use, temp);
            } 
        }

        return cache[i] = Math.min(use, notUse);
    }

    public int minExtraChar(String word, String[] dictionary) {
        HashSet<String> dictionarySet = new HashSet<>();
        int lengthOfWord = word.length();
        Integer cache[] = new Integer[lengthOfWord];

        addWordsToSet(dictionary, dictionarySet);

        return partitionString(0, word, dictionarySet, cache);

    }
}

/*

 */