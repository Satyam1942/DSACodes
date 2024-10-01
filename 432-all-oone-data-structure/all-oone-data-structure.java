class Node {
    HashSet<String> setOfStrings;
    int frequency;
    Node  next;
    Node prev;

    Node(int frequency) {
        setOfStrings = new HashSet<>();
        this.frequency = frequency;
        this.next = null;
        this.prev = null;
    }

    void addString(String str) {
        setOfStrings.add(str);
    }

    void removeString(String str) {
        setOfStrings.remove(str);
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;
    DoublyLinkedList() {
        head = new Node(0);
        tail = new Node(0);

        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node prev, Node cur , Node next) {
        prev.next = cur;
        cur.prev = prev;
        cur.next = next;
        next.prev = cur;
    }

    void deleteNode (Node cur) {
        Node prev = cur.prev;
        Node next = cur.next;
        prev.next = next;
        next.prev = prev;
        cur.next = null;
        cur.prev = null;
    }
}

class AllOne {
    DoublyLinkedList dll;
    HashMap<String,Integer> frequencyMap;
    HashMap<Integer,Node> addressMap;

    public AllOne() {
        dll = new DoublyLinkedList();
        frequencyMap = new HashMap<>();
        addressMap = new HashMap<>();
        addressMap.put(0,dll.head);
    }
    
    public void inc(String key) {
        int curFreq = frequencyMap.getOrDefault(key,0);
        Node curNode = addressMap.get(curFreq);

        int newFreq = curFreq+1;

        //create/modify new Node
        if(addressMap.containsKey(newFreq)) {
            Node newNode = addressMap.get(newFreq);
            newNode.setOfStrings.add(key);
        } else {
            Node newNode  = new Node(newFreq);
            newNode.setOfStrings.add(key);
            Node nextNode = curNode.next;
            dll.addNode(curNode,newNode,nextNode);
            addressMap.put(newFreq,newNode);
        }   

        frequencyMap.put(key,newFreq);

        //delete / modify oldNode;
        if(curNode!= dll.head && curNode.setOfStrings.size() == 1) {
            dll.deleteNode(curNode);
            addressMap.remove(curFreq);
        } else {
            curNode.setOfStrings.remove(key);
        }
    }
    
    public void dec(String key) {
        int curFreq = frequencyMap.getOrDefault(key,0);
        Node curNode = addressMap.get(curFreq);
        int newFreq = curFreq-1;

        if(newFreq!=0) {
            //create/modify new Node
            if(addressMap.containsKey(newFreq)) {
                Node newNode = addressMap.get(newFreq);
                newNode.setOfStrings.add(key);
            } else {
                Node newNode  = new Node(newFreq);
                newNode.setOfStrings.add(key);
                Node prevNode = curNode.prev;
                dll.addNode(prevNode,newNode,curNode);
                addressMap.put(newFreq,newNode);
            }   
            frequencyMap.put(key,newFreq);
        } else {
            frequencyMap.remove(key);
        }


        //delete / modify oldNode;
        if(curNode!= dll.head && curNode.setOfStrings.size() == 1) {
            dll.deleteNode(curNode);
            addressMap.remove(curFreq);
        } else {
            curNode.setOfStrings.remove(key);
        }
    }
    
    public String getMaxKey() {
        Node maxNode = dll.tail.prev;
        StringBuilder maxKey = new StringBuilder();

        for(String str : maxNode.setOfStrings) {
            maxKey.append(str);
            break;
        }
        return maxKey.toString();
    }
    
    public String getMinKey() {
        Node minNode = dll.head.next;
        StringBuilder minKey = new StringBuilder();

        for(String str : minNode.setOfStrings) {
            minKey.append(str);
            break;
        }
        return minKey.toString();   
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */