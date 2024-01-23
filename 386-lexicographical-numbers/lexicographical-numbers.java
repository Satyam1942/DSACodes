class Node{
    Node links[];
    boolean flag;
    Node(){
        links = new Node[26];
        flag = false;
    }

    boolean containsKey(int key){
        return links[key]!=null;
    }

    void put(int digit){
        links[digit] = new Node();
    }

    Node get(int digit){
        return links[digit];
    }

    void setFlag(boolean ans){
        flag = ans;
    }

    boolean getFlag(){
        return flag;
    }
}

class Trie{
    Node node;
    Trie(){
        node = new Node();
    }

    void insert(int num){
        Node temp = node;
        String str = String.valueOf(num);
        for(int i=0;i<str.length();i++){
            int digit = (int)str.charAt(i)-48;
            if(!temp.containsKey(digit)){
                temp.put(digit);
            }
            temp = temp.get(digit);
        }
        temp.setFlag(true);
    } 

}

class Solution {

    void getNumbersLexicographical(Node node, int temp, List<Integer> list){
        if(node.getFlag())
            list.add(temp);

        for(int i=0;i<=9;i++){
            if(node.containsKey(i)){
                temp*=10;
                temp+=i;
                getNumbersLexicographical(node.get(i),temp,list);
                temp-=i;
                temp/=10;
            }
        }
    }

    public List<Integer> lexicalOrder(int n) {
        Trie trie = new Trie();
        for(int i=1;i<=n;i++){
            trie.insert(i);
        }

        List<Integer> ans = new ArrayList<>();
        getNumbersLexicographical(trie.node,0,ans);

        return ans;

    }
}