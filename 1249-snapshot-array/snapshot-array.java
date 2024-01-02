class SnapshotArray {
    HashMap<Integer, TreeMap<Integer, Integer>> map;
    int snapshotArray[];
    int length;
    int snapId;

    public SnapshotArray(int length) {
        map = new HashMap<>();
        this.length = this.length;
        snapId = -1;
        snapshotArray = new int[length];
    }

    public void set(int index, int val) {
        int oldVal = snapshotArray[index];

        if (snapId >= 0) {
            if (!map.containsKey(index))
                map.put(index, new TreeMap<>());
            if(!map.get(index).containsKey(snapId)) 
                map.get(index).put(snapId, oldVal);
        }
        snapshotArray[index] = val;
    }

    public int snap() {
        return ++snapId;
    }

    public int get(int index, int snapId) {
        if (map.containsKey(index)) {
            Integer key = map.get(index).ceilingKey(snapId);
            if (key!=null)
                return map.get(index).get(key);

        }
        return snapshotArray[index];
    }
}
/*
[0]
0->(1->(0),)
 */
/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */