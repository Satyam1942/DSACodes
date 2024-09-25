class Node {
    Node links[];
    int prefixCount;
    boolean isWordComplete;

    Node() {
        links = new Node[26];
        prefixCount = 0;
        isWordComplete = false;
    }

    boolean containsKey(char token) {
        return links[(int)token-97]!=null;
    }

    void put(char token) {
        links[(int)token-97] = new Node();
    }

    Node get(char token) {
        return links[(int)token-97];
    }

    boolean getIsWordComplete() {
        return isWordComplete;
    }

    void  setIsWordComplete() {
        isWordComplete = true;
    }

    void setPrefixCount() {
        prefixCount++;
    }

    int getPrefixCount() {
        return prefixCount;
    }
}

class Trie {
    Node node;

    Trie() {
        node = new Node();
    }

    void insertWord(String word) {
        Node temp = node;
        int length = word.length();

        for(int i=0;i<length;i++) {
            char token = word.charAt(i);
            if(!temp.containsKey(token)) {
                temp.put(token);
            }
            temp = temp.get(token);
            temp.setPrefixCount();
        }

        temp.setIsWordComplete();
    }

    int commonPrefixCount(String word) {
        Node temp = node;
        int length = word.length();
        int prefixCount = 0;

        for(int i=0;i<length;i++) {
            char token = word.charAt(i);
            if(temp.containsKey(token)) {
                prefixCount += temp.get(token).getPrefixCount();
            } else  {
                break;
            }
            temp = temp.get(token);
        }
        
        return prefixCount;
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        int length = words.length;

        for(int i=0;i<length;i++) {
            trie.insertWord(words[i]);
        }

        int prefixScore[] = new int[length];
        for(int i=0;i<length;i++) {
            int prefixCount = trie.commonPrefixCount(words[i]);
            prefixScore[i] = prefixCount;
        }

        return prefixScore;
    }
}