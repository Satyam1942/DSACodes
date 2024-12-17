class Pair {
    char token ;
    int freq ; 
    Pair(char token, int freq) {
        this.token = token;
        this.freq = freq;
    }
}

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int length = s.length();
        TreeMap<Character, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<length;i++) {
            char token = s.charAt(i);
            int curFreq = map.getOrDefault(token,0);
            map.put(token,curFreq+1);
        }

        Queue<Pair> q = new LinkedList<>();

        while(!map.isEmpty()) {
            char token = map.lastKey();
            int freq = map.get(token);
            int repeatTimes = 0;
            map.remove(token);

            if(q.isEmpty()) {
                if(freq>repeatLimit){
                    repeatTimes = repeatLimit;
                    q.add(new Pair(token, freq-repeatLimit));
                } else {
                    repeatTimes = freq;
                }

                while(repeatTimes-->0) {
                    sb.append(token);
                }
            } else {
                sb.append(token);
                if(freq>1) {
                    map.put(token, freq-1);
                }
                char newToken = q.peek().token;
                int newFreq= q.peek().freq;
                q.poll();
                map.put(newToken, newFreq);
            }
        }

        String repeatLimitedString = sb.toString();
        return repeatLimitedString;
    }
}
/*

    zzcccca
    zczcac
*/