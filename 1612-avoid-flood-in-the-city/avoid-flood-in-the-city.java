class Solution {
    public int[] avoidFlood(int[] rains) {
        int length = rains.length;
        int ans[] = new int[length];

        TreeSet<Integer> zeroPtr = new TreeSet<>();
        HashMap<Integer, Integer> cache = new HashMap<>();

        for (int idx = 0; idx < length; idx++) {
            if (rains[idx] > 0) {
                if (cache.containsKey(rains[idx])) {
                    int prevIndex = cache.get(rains[idx]);
                    Integer key = zeroPtr.ceiling(prevIndex);
                    if (key == null)
                        return new int[0];
                    else {
                        ans[key] = rains[idx];
                        zeroPtr.remove(key);
                    }
                }

                cache.put(rains[idx], idx);
                ans[idx] = -1;
            } else
                zeroPtr.add(idx);
        }

        for (Integer idx : zeroPtr) {
            ans[idx] = 1;
        }

        return ans;

    }
}