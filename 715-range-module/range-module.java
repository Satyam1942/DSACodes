class RangeModule {

    TreeMap<Integer,Integer> map;
    public RangeModule() {
        map = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        int newStart = left;
        int newEnd = right;
        Integer floorStart = map.floorKey(left);
        Integer floorEnd = map.floorKey(right);

        if(floorStart==null || map.get(floorStart)<left )
            newStart = left;
        else
            newStart = floorStart;
            
        if(floorEnd==null || map.get(floorEnd)<=right)
            newEnd = right;
        else
            newEnd = map.get(floorEnd);
        
        map.subMap(newStart,newEnd).clear();
        map.put(newStart,newEnd);
    }
    
    public boolean queryRange(int left, int right) {
        Integer floorLeft = map.floorKey(left);
        
        if(floorLeft==null || map.get(floorLeft)<right)
            return false;
        
        return true;
    }
    
    public void removeRange(int left, int right) {
        Integer floorLeft = map.floorKey(left);
        Integer floorRight = map.floorKey(right);
        int newEnd = 0;
        if(floorRight!=null)
            newEnd =  map.get(floorRight);
        
        if(floorLeft!=null && map.get(floorLeft)>left)
            map.put(floorLeft,left);

        if(floorRight!=null && newEnd>=right)
            map.put(right,newEnd);

        map.subMap(left,right).clear();
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */