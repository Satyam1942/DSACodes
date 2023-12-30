class HitCounter {

    ArrayDeque<Integer> dq;
    int timeDur;

    public HitCounter() {
        dq = new ArrayDeque<>();
        timeDur = 300;
    }

    public void hit(int timestamp) {
        dq.addLast(timestamp);
    }

    public int getHits(int timestamp) {
        int lowerBound = Math.max(timestamp - timeDur, 0);
        while(!dq.isEmpty() && dq.peekFirst()<=lowerBound) dq.removeFirst();
        return dq.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */