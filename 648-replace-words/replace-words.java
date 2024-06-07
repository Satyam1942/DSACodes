class Solution {
    void addToSet(List<String> dictionary, HashSet<String> dictionarySet) {
        for (String word : dictionary) {
            dictionarySet.add(word);
        }
    }

    void buildWords(String sentence, List<String> words) {
        int lengthOfSentence = sentence.length();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < lengthOfSentence; i++) {
            char token = sentence.charAt(i);
            if (token == ' ') {
                words.add(word.toString());
                word = new StringBuilder();
            } else {
                word.append(token);
            }
        }
        words.add(word.toString());
    }

    String mapWords(List<String> words,  HashSet<String> dictionarySet) {

        HashMap<String, String> mapRoot = new HashMap<>();
        StringBuilder ansString = new StringBuilder();

        for (String curWord : words) {
            if (mapRoot.containsKey(curWord)) {
                ansString.append(mapRoot.get(curWord) + " ");
                continue;
            }

            StringBuilder root = new StringBuilder();
            boolean flag = false;
            for (int i = 0; i < curWord.length(); i++) {
                char curToken = curWord.charAt(i);
                root.append(curToken);
                if (dictionarySet.contains(root.toString())) {
                    flag = true;
                    ansString.append(root.toString() + " ");
                    mapRoot.put(curWord, root.toString());
                    break;
                }
            }
            if (!flag) {
                ansString.append(curWord + " ");
                mapRoot.put(curWord, curWord);
            }
        }
        return ansString.toString();
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        int lengthOfDictionary = dictionary.size();
        int lengthOfSentence = sentence.length();
        List<String> words = new ArrayList<>();
        HashSet<String> dictionarySet = new HashSet<>();

        addToSet(dictionary, dictionarySet);
        buildWords(sentence, words);
        String ansString = mapWords(words,dictionarySet);

        int ansLength = ansString.length();
        return ansString.substring(0, ansLength - 1);

    }
}