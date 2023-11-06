class SeatManager {
    
    TreeSet<Integer> unreserved;
    
    public SeatManager(int n) {
        unreserved = new TreeSet<>();
        for(int i=1;i<=n;i++)unreserved.add(i);
    }
    
    public int reserve() {
        int seatNo = unreserved.pollFirst();
        return seatNo;
    }
    
    public void unreserve(int seatNumber) {
        unreserved.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */