class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int length = hand.length;
        if (length % groupSize != 0)
            return false;

        for (int i = 0; i < length; i++) {
            int curFreq = freq.getOrDefault(hand[i], 0);
            freq.put(hand[i], curFreq + 1);
        }

        while (!freq.isEmpty()) {
            int firstElement = freq.firstKey();
            int curFreq = freq.get(firstElement);
            if (curFreq != 1)
                freq.put(firstElement, curFreq - 1);
            else
                freq.remove(firstElement);

            for (int i = firstElement + 1; i < firstElement + groupSize; i++) {
                if (!freq.containsKey(i))
                    return false;
                else {
                    curFreq = freq.get(i);
                    if (curFreq != 1)
                        freq.put(i, curFreq - 1);
                    else
                        freq.remove(i);
                }
            }
        }

        return true;

    }
}