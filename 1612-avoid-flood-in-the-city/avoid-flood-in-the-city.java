class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> zeroIndices = new TreeSet<>();
        int length = rains.length;
        int dryLake[] = new int[length];

        for (int i = 0; i < length; i++) {
            int lake = rains[i];
            if (lake == 0) {
                zeroIndices.add(i);
            } else {
                dryLake[i] = -1;
                int pairIndex = map.getOrDefault(lake, -1);
                if (pairIndex == -1) {
                    map.put(lake, i);
                } else {
                    Integer pastZeroIndex = zeroIndices.ceiling(pairIndex);
                    if (pastZeroIndex == null) {
                        return new int[] {};
                    } else {
                        dryLake[pastZeroIndex] = lake;
                        zeroIndices.remove(pastZeroIndex);
                    }
                    map.put(lake, i);
                }
            }
        }

        for (int i = 0; i < length; i++) {
            if (dryLake[i] == 0) {
                dryLake[i] = 1;
            }
        }

        return dryLake;
    }
}

/*
    
    1-0
    2-1
    3-3

    (0,2)
    (0,4)
           3, 3 2, 1
*/