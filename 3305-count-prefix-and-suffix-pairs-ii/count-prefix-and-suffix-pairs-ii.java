class Node{
    HashMap<List<Character>,Node> node;
    int count;
    Node(){
        node = new HashMap<>();
        count = 0;
    }

    void put(char preCh,char sufCh){
        List<Character> list = new ArrayList<>();
        list.add(preCh);
        list.add(sufCh);
        node.put(list, new Node());
    }

    Node get(char preCh,char sufCh){
         List<Character> list = new ArrayList<>();
        list.add(preCh);
        list.add(sufCh);
        return  node.get(list);
    }
    boolean contains(char preCh,char sufCh){
          List<Character> list = new ArrayList<>();
        list.add(preCh);
        list.add(sufCh);
        return node.get(list)!=null;
    }

    void incrementCount(){
        count++;
    }
    void decrementCount(){
        count--;
    }

    int  getCount(){
        return count;
    }
}

class Trie{
    Node node;
    Trie(){
        node = new Node();
    }

    void insert(String word){
        Node temp  = node;
        for(int i=0;i<word.length();i++){
            char preCh = word.charAt(i);
            char sufCh  = word.charAt(word.length()-i-1);
            if(!temp.contains(preCh,sufCh))
               temp.put(preCh,sufCh);
            temp.incrementCount();
            temp = temp.get(preCh,sufCh);
        }
        temp.incrementCount();
    }

    int getCount(String word){
        Node temp = node;
        for(int i=0;i<word.length();i++){
           char preCh = word.charAt(i);
            char sufCh  = word.charAt(word.length()-i-1);
            if(temp.contains(preCh,sufCh)){
                temp.decrementCount();
                temp =temp.get(preCh,sufCh);
            }
            else 
                return 0;
        }
        temp.decrementCount();
        int count =  temp.getCount();
        return  count;
    }
}



class Solution {
    public long countPrefixSuffixPairs(String[] words) {
        long count  =0 ;
        Trie trie = new Trie();

        for(int i=0;i<words.length;i++){
            trie.insert(words[i]);
        }

        for(int i=0;i<words.length;i++){
          
            count += trie.getCount(words[i]);
        }

        return count;
    }
}