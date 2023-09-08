class Node
{
    int val,freq,key;
    Node next;
    Node prev;
    Node(int val, int freq , int key)
    {
        this.val = val;
        this.key = key;
        this.freq = freq;
        next = null;
        prev = null;
    }
}

class LFUCache {
    TreeMap<Integer,Node[]> map;
    HashMap<Integer,Node> address;
    
    int capacity;

    public LFUCache(int capacity) {
        map = new TreeMap<>();
        address = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {

        if(!address.containsKey(key)) return -1;

        Node nodeToRemove = address.get(key);
        int value = nodeToRemove.val;
        nodeToRemove.prev.next = nodeToRemove.next;
        nodeToRemove.next.prev = nodeToRemove.prev;

        int freq = nodeToRemove.freq;
        nodeToRemove.freq = freq+1;
        Node h = map.get(freq)[0];
        Node t = map.get(freq)[1];
        if(h.next == t) map.remove(freq);

        if(map.containsKey(freq+1)) 
        {
            Node tempHead = map.get(freq+1)[0];
            nodeToRemove.next = tempHead.next;
            tempHead.next.prev = nodeToRemove;
            tempHead.next = nodeToRemove;
            nodeToRemove.prev = tempHead;
        }
        else
        {
            Node tempHead = new Node(0,freq+1,-1) ;
            Node tempTail = new Node(0,freq+1,-1);
            tempHead.next = nodeToRemove;
            nodeToRemove.prev = tempHead;
            nodeToRemove.next = tempTail;
            tempTail.prev = nodeToRemove;
            
            Node arrNode[] = {tempHead,tempTail};
            map.put(freq+1,arrNode);
        }
        

        return value;
    }
    
    public void put(int key, int value) {
       
            if(address.containsKey(key))
            {
                //update
                Node nodeToUpdate = address.get(key);
                nodeToUpdate.val = value;
                address.put(key,nodeToUpdate);
                nodeToUpdate.prev.next = nodeToUpdate.next;
                nodeToUpdate.next.prev = nodeToUpdate.prev;

                int freq = nodeToUpdate.freq;
                nodeToUpdate.freq = freq+1;
                Node h = map.get(freq)[0];
                Node t = map.get(freq)[1];
                if(h.next == t) map.remove(freq);

                if(map.containsKey(freq+1)) 
                {
                    Node tempHead = map.get(freq+1)[0];
                    nodeToUpdate.next = tempHead.next;
                    tempHead.next.prev = nodeToUpdate;
                    tempHead.next = nodeToUpdate;
                    nodeToUpdate.prev = tempHead;
                }
               else
               {
                    Node tempHead = new Node(0,freq+1,-1) ;
                    Node tempTail = new Node(0,freq+1,-1);
                    tempHead.next = nodeToUpdate;
                    nodeToUpdate.prev = tempHead;
                    nodeToUpdate.next = tempTail;
                    tempTail.prev = nodeToUpdate;
            
                    Node arrNode[] = {tempHead,tempTail};
                    map.put(freq+1,arrNode);
               }
            }
            else
            {
                System.out.println(address.size());
                if(address.size()==capacity)
                {
                    //remove
                    int k = map.firstKey();
                   Node curTail =  map.get(k)[1];
                   Node curHead = map.get(k)[0];
                   int keyToRemove = curTail.prev.key;
                   address.remove(keyToRemove);
                   curTail.prev.prev.next = curTail;
                   curTail.prev = curTail.prev.prev;

                   if(curHead.next == curTail) map.remove(k);
                  
                }

                //create
                Node newNode = new Node(value,1,key);
                address.put(key,newNode);
                if(map.containsKey(1))
                {
                    Node tempHead = map.get(1)[0];
                    newNode.next = tempHead.next;
                    tempHead.next.prev =newNode;
                    tempHead.next = newNode;
                    newNode.prev = tempHead; 
                }
                else
                {
                    Node tempHead = new Node(0,1,-1) ;
                    Node tempTail = new Node(0,1,-1);
                    tempHead.next = newNode;
                    newNode.prev = tempHead;
                    newNode.next = tempTail;
                    tempTail.prev =newNode;
            
                    Node arrNode[] = {tempHead,tempTail};
                    map.put(1,arrNode);                    
                }
            }
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */