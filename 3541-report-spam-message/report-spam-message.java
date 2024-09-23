class Solution {
    void addToDictionary(String[] bannedWords, HashSet<String> bannedDictionary) {
        for(String word : bannedWords) {
            bannedDictionary.add(word);
        }
    }
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String> bannedDictionary = new HashSet<>();
        int messageCount = message.length;
        int bannedWordCount = 0;

        addToDictionary(bannedWords, bannedDictionary);

        for(int i=0;i<messageCount;i++) {
            if(bannedDictionary.contains(message[i])) {
                bannedWordCount++;
            }
        }
        return bannedWordCount>=2;
    }
}