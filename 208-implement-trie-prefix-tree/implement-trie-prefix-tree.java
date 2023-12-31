class Node
{
    Node[] links;
    boolean flag;
    Node()
    {
        links = new Node[26];
        flag = false;
    }

    public boolean containsKey(char ch)
    {
        return links[ch-97]!=null;
    }

    public void put(char ch)
    {
        links[ch-97] = new Node();
    }

    public Node get(char ch)
    {
        return links[ch-97];
    }

    public void setFlag(boolean ans)
    {
        flag = ans;
    }

    public boolean getFlag()
    {
        return flag;
    }
}

class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        int lengthOfWord = word.length();
        Node temp = root;

        for(int i=0;i<lengthOfWord;i++)
        {
            char ch = word.charAt(i);
            if(!temp.containsKey(ch)) temp.put(ch);
            temp = temp.get(ch);
        }
        temp.setFlag(true);
    }
    
    public boolean search(String word) {
        int lengthOfWord = word.length();
        Node temp = root;

        for(int i=0;i<lengthOfWord;i++)
        {
            char ch = word.charAt(i);
            if(temp.containsKey(ch)) temp = temp.get(ch);
            else return false;
        }

        return temp.getFlag();
    }
    
    public boolean startsWith(String prefix) {
        int lengthOfWord = prefix.length();
        Node temp = root;

        for(int i=0;i<lengthOfWord;i++)
        {
            char ch = prefix.charAt(i);
            if(temp.containsKey(ch)) temp = temp.get(ch);
            else return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */