class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int length = basket1.length;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        Arrays.sort(basket1);
        Arrays.sort(basket2);

        for (int i = 0; i < length; i++) {
            int key = basket1[i];
            int freq = map1.getOrDefault(key, 0);
            map1.put(key, freq + 1);
        }

        for (int i = 0; i < length; i++) {
            int key = basket2[i];
            int freq = map2.getOrDefault(key, 0);
            map2.put(key, freq + 1);
        }

        List<Integer> fruitsToSwap = new ArrayList<>();
        for (Map.Entry<Integer, Integer> i : map1.entrySet()) {
            int key = i.getKey();
            int freq1 = i.getValue();
            if (map2.containsKey(key)) {
                int freq2 = map2.get(key);
                if ((freq1 + freq2) % 2 != 0) {
                    return -1;
                } else {
                    int eventualFreq = (freq1 + freq2) / 2;
                    if (freq1 > freq2) {
                        int delta = freq1 - eventualFreq;
                        while (delta-- > 0) {
                            fruitsToSwap.add(key);
                        }
                    } else {
                        int delta = freq2 - eventualFreq;
                        while (delta-- > 0) {
                            fruitsToSwap.add(key);
                        }
                    }
                }
            } else {
                if (freq1 % 2 != 0) {
                    return -1;
                } else {
                    freq1 /= 2;
                    while (freq1-- > 0) {
                        fruitsToSwap.add(key);
                    }
                }
            }
        }

        for (Map.Entry<Integer, Integer> i : map2.entrySet()) {
            int key = i.getKey();
            int freq2 = i.getValue();

            if (!map1.containsKey(key)) {
                if (freq2 % 2 != 0) {
                    return -1;
                } else {
                    freq2 /= 2;
                    while (freq2-- > 0) {
                        fruitsToSwap.add(key);
                    }
                }
            }
        }   

        if(fruitsToSwap.size()%2!=0) {
            return -1;
        }

        Collections.sort(fruitsToSwap);
        int minElement = Math.min(basket1[0], basket2[0]);
        long cost = 0;
        for(int i=0; i<fruitsToSwap.size()/2; i++) {
            cost += Math.min(fruitsToSwap.get(i), 2*minElement);
        }

        return cost;
    }
}

/*
    1-2
    2-1
    4-1 

    2-3
    4-1
*/