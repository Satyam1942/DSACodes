class HitCounter {

    TreeMap<Integer, Integer> map;
    int prevTimestamp;
    int timeDur;

    public HitCounter() {
        map = new TreeMap<>();
        map.put(0,0);
        prevTimestamp = 0;
        timeDur = 300;
    }

    public void hit(int timestamp) {
        int prevFreq = (!map.isEmpty()) ? map.get(prevTimestamp) : 0;
        map.put(timestamp, prevFreq + 1);
        prevTimestamp = timestamp;
    }

    public int getHits(int timestamp) {
        int lowerBound = Math.max(timestamp - timeDur, 0);
        int currHits = map.get(prevTimestamp);
        Integer lowerBoundTimestamp = map.floorKey(lowerBound);
        int lowerBoundHits = (lowerBoundTimestamp == null) ? currHits : map.get(lowerBoundTimestamp);

        return currHits - lowerBoundHits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */