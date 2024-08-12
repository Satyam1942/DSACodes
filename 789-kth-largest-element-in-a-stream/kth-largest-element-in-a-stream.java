class KthLargest {
    PriorityQueue<Integer> stream;
    int maxStreamSize;

    public KthLargest(int k, int[] nums) {
        stream = new PriorityQueue<>();
        maxStreamSize = k;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int val = nums[i];
            stream.add(val);
            if (stream.size() > maxStreamSize)
                stream.poll();
        }
    }

    public int add(int val) {
        stream.add(val);
        if (stream.size() > maxStreamSize)
            stream.poll();
        return stream.peek();
    }   
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */