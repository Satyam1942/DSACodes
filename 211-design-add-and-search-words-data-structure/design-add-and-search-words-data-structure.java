class Node{

    Node[] links;
    boolean flag;

    Node(){
       links = new Node[26];
       flag = false;
    }

    public boolean containsKey(char ch){
        return links[ch-97]!=null;
    }

    public void put(char ch){
        links[ch-97] = new Node();
    }

    public Node get(char ch){
        return links[ch-97];
    }

    public void setFlag(boolean ans){
        flag = ans;
    }

    public  boolean getFlag(){
        return flag;
    }
}



class Trie{
    Node root;

    Trie(){
        root =  new Node();
    }

    void insert(String word){
        Node temp = root;
        int length = word.length();
        for(int i=0;i<length;i++){
            char token = word.charAt(i);
            if(!temp.containsKey(token))
                temp.put(token);
            temp = temp.get(token);
        }
        temp.setFlag(true);
    }

    boolean search(String word,Node node){
        int length = word.length();

        for(int i=0;i<length;i++){

            if(word.charAt(i)=='.'){
                boolean flag = false;
                for(char ch = 'a';ch<='z';ch++){
                    if(node.containsKey(ch)){
                        flag = search(word.substring(i+1),node.get(ch));
                    }
                    if(flag)
                        return true;
                }
                return flag;
            }
            else{
                char ch = word.charAt(i);
                if(!node.containsKey(ch))
                    return false;
                node = node.get(ch);
            }
        }

        return node.getFlag();
    }
}

class WordDictionary {

    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.insert(word);
    }
    public boolean search(String word) {
            return trie.search(word,trie.root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */