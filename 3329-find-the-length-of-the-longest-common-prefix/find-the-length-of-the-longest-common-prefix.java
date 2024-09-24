class Node {
    Node links[];
    boolean flag;

    Node() {
        links = new Node[10];
        flag = false;
    }

    boolean containsKey(int digit) {
        return links[digit]!=null;
    }

    void put(int digit) {
        links[digit] = new Node();
    }

    Node get(int digit) {
        return links[digit];
    }

    boolean getFlag() {
        return flag;
    }

    void  setFlag() {
        flag = true;
    }
}

class Trie {
    Node node;

    Trie() {
        node = new Node();
    }

    void getAllDigits(int number, Stack<Integer> digitStack) {
        while(number>0) {
            int digit = number%10;
            digitStack.push(digit);
            number/=10;
        }
    }

    void insertNumber(int number) {
        Node temp = node;
        Stack<Integer> digitStack = new Stack();
        getAllDigits(number, digitStack);

        while(!digitStack.isEmpty()) {
            int digit = digitStack.pop();
            if(!temp.containsKey(digit)) {
                temp.put(digit);
            }
            temp = temp.get(digit);
        }
        temp.setFlag();
    }

    int longestCommonPrefix(int number) {
        int prefixLength = 0;
        Node temp = node;
        Stack<Integer> digitStack = new Stack();
        getAllDigits(number, digitStack);

        while(!digitStack.isEmpty()) { 
            int digit = digitStack.pop();
            if(!temp.containsKey(digit)) {
                break;
            }
            temp = temp.get(digit);
            prefixLength++;
        }   

        return prefixLength;
    }
}

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        for(int number : arr2) {
            trie.insertNumber(number);
        }

        int longestCommonPrefixLength = 0;
        for(int number : arr1) {
            int commonPrefixLength = trie.longestCommonPrefix(number);
            longestCommonPrefixLength = Math.max(longestCommonPrefixLength, commonPrefixLength);
        }
        return longestCommonPrefixLength;
    }
}