class Solution {
    public String frequencySort(String s) {
        int freq[] = new int[128];
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            freq[(int) ch]++;
        }

        TreeMap<Integer, HashSet<Character>> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < 128; i++) {
            if (freq[i] != 0) {
                char ch = (char) i;
                if (!map.containsKey(freq[i]))
                    map.put(freq[i], new HashSet<>());
                map.get(freq[i]).add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, HashSet<Character>> i : map.entrySet()) {
            HashSet<Character> set = i.getValue();
            int times = i.getKey();
            for (Character ch : set) {
                for (int j = 0; j <times; j++)
                    sb.append(ch);
            }
        }

        return sb.toString();

    }
}