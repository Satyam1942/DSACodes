class Node{
    int key;
    int val;
    Node next;
    Node prev;
    Node(int key, int val){
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}

class DoublyLinkedList{
    Node head;
    Node tail;
    DoublyLinkedList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    Node addToFront(Node newNode){
        Node nextNode = head.next;
        newNode.next = nextNode;
        nextNode.prev = newNode;
        newNode.prev = head;
        head.next = newNode;
        return  head;
    }

    Node removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        node.next = null;
        node.prev = null;
        return node;
    }

}

class LRUCache {
    DoublyLinkedList dll;
    HashMap<Integer,Node> map;
    int curSize;
    int capacity;

    public LRUCache(int capacity) {
        dll = new DoublyLinkedList();
        map = new HashMap<>();
        curSize = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            int val = node.val;
            dll.removeNode(node);
            dll.addToFront(node);
            return val;
        }else
            return -1;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){

            if(map.size()==capacity){
                Node nodeToBeDeleted = dll.tail.prev;
                dll.removeNode(nodeToBeDeleted);
                map.remove(nodeToBeDeleted.key);
            }
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            dll.addToFront(newNode);
        }else{
            Node node = map.get(key);
            node.val = value;
            dll.removeNode(node);
            dll.addToFront(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */