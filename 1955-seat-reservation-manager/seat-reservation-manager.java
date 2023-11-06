class SeatManager {
    
    TreeSet<Integer> unreserved;
    int smallest;
    public SeatManager(int n) {
        unreserved = new TreeSet<>();
        smallest = 1;
    }
    
    public int reserve() {
        int seatNo = (unreserved.isEmpty())? smallest++ : unreserved.pollFirst();
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