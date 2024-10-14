class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int length = nums.length;
        for(int i=0;i<length;i++) {
            pq.add(nums[i]);
        }
        long score = 0;
        
        while(k-->0) {
            int curScore = pq.poll();
            int newScore = (int)Math.ceil(curScore/3.0);
            pq.add(newScore);
            score+=curScore;
        }

        return score;
    }
}

