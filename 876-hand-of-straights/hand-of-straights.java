class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        Arrays.sort(hand);
        HashMap<Integer, Queue<Integer>> map = new HashMap<>();
        int totalCards = hand.length;
   
        for (int idx = 0; idx < totalCards; idx++) {
            if (map.containsKey(hand[idx])) {
                int val = map.get(hand[idx]).poll();
                if (map.get(hand[idx]).size() == 0) map.remove(hand[idx]);
                if (val == 0) continue;

                int key = hand[idx] + 1;
                int newVal = val - 1;

                if (!map.containsKey(key))map.put(key, new LinkedList<>());
                map.get(key).add(newVal);

            } else {
                int key = hand[idx] + 1;
                int val = groupSize-2;
                if(val>=0)
                {
                if (!map.containsKey(key))map.put(key, new LinkedList<>());
                map.get(key).add(val);
                }
            }
        }
  
        return map.isEmpty();

    }
}