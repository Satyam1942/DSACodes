class Solution {
    public int connectSticks(int[] sticks) {
        int length = sticks.length;
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < length; i++) {
            pq.add(sticks[i]);
        }

        while (pq.size() > 1) {
            int stick1 = pq.poll();
            int stick2 = pq.poll();
            int tempCost = stick1 + stick2;
            cost += tempCost;
            pq.add(tempCost);
        }

        return cost;

    }
}