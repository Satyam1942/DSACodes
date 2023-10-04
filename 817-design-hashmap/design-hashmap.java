
class MyHashMap {
    List<LinkedList<int[]>> map;
    public MyHashMap() {
        map = new ArrayList<>();
        for(int i=0;i<(1e5);i++) map.add(new LinkedList<>());
    }
    public int hash(int val)
    {
        return (val%((int)1e5));
    }
    public void put(int key, int value) {
        int index = hash(key);
        LinkedList<int[]> head = map.get(index);

        boolean flag = false;
         int indexLL=-1;
        for(int[] i:head)
        {
            indexLL++;
            if(i[0]==key) { flag = true; break;}
        }
       
        if(!flag)map.get(index).addLast(new int[]{key,value});
        else map.get(index).set(indexLL,new int[]{key,value});
    }
    
    public int get(int key) {
        int index = hash(key);
        
        LinkedList<int[]> head =  map.get(index);
         for(int[] i:head)
        {
            if(i[0]==key)return i[1];
        }
        return -1;
        
    }
    
    public void remove(int key) {
        
        int index = hash(key);
        LinkedList<int[]> head =  map.get(index);
        int indexLL=-1;
         for(int[] i:head)
        {
             indexLL++;
            if(i[0]==key)  break;
        }
    
        if(indexLL==-1) return;
        map.get(index).remove(indexLL);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */