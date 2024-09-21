class Node {
    Node links[];
    boolean flag;

    Node() {
        links = new Node[10];
        flag = false;
    }

    boolean containsKey(char token) { 
        return links[(int)token-48]!=null; 
    }

    Node get(char token) {
        return links[(int)token-48];
    }

    void put(char token) {
        links[(int)token-48] = new Node();
    }

    void setFlag(){
        flag = true;
    }

    boolean getFlag(){
        return flag;
    }
}

class Trie {
    Node node;

    Trie() {
        node = new Node();
    }

    void insertNumber(int num) {
        Node temp = node;
        String strNum = String.valueOf(num);
        int length = strNum.length();
        for(int i=0;i<length;i++){
            char token = strNum.charAt(i);
            if(!temp.containsKey(token))
                temp.put(token);
            temp = temp.get(token);
        }
        temp.setFlag();
    }
}

class Solution {
    public void getNumbersInOrder(Node node, int tempNum , List<Integer> orderedList){
        if(node.getFlag())
            orderedList.add(tempNum);

        for(int i=0;i<=9;i++){
            char token = (char)(i+48);
            if(node.containsKey(token)){
                getNumbersInOrder(node.get(token), tempNum*10+i, orderedList);
            }
        }
    }

    public List<Integer> lexicalOrder(int n) {
        Trie trie = new Trie();
        List<Integer> sortedList = new ArrayList<>();

        for(int i=1;i<=n;i++)
            trie.insertNumber(i);
   
        getNumbersInOrder(trie.node, 0, sortedList);
        return sortedList;
    }
}