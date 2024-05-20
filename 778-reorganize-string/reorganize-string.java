class Pair implements Comparator<Pair> {
    char token;
    int freq;

    Pair() {
    }

    Pair(char token, int freq) {
        this.token = token;
        this.freq = freq;
    }

    @Override
    public int compare(Pair a, Pair b) {
        return b.freq - a.freq;
    }
}

class Solution {
    public String reorganizeString(String s) {
        int length = s.length();
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            int curFreq = freq.getOrDefault(ch, 0);
            freq.put(ch, curFreq + 1);
        }

        PriorityQueue<Pair> activePriorityQueue = new PriorityQueue<>(new Pair());

        for (Map.Entry<Character, Integer> i : freq.entrySet()) {
            char token = i.getKey();
            int f = i.getValue();
            if (f > (int) (Math.ceil(length / 2.0)))
                return "";
            activePriorityQueue.add(new Pair(token, f));
        }

        StringBuilder sb = new StringBuilder();
        while (!activePriorityQueue.isEmpty()) {
            char token1 = activePriorityQueue.peek().token;
            int f1 = activePriorityQueue.peek().freq;
            activePriorityQueue.poll();
            sb.append(token1);

            if (activePriorityQueue.isEmpty()) 
                break;

            char token2 = activePriorityQueue.peek().token;
            int f2 = activePriorityQueue.peek().freq;
            activePriorityQueue.poll();
            sb.append(token2);

            if (f1 > 1)
                activePriorityQueue.add(new Pair(token1, f1 - 1));
            if (f2 > 1)
                activePriorityQueue.add(new Pair(token2, f2 - 1));

        }

        return sb.toString();
    }
}