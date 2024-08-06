class Solution {
    public int minimumPushes(String word) {
        int length = word.length();
        int freq[] = new int[26];
        for(int i=0;i<length;i++){
            char token = word.charAt(i);
            freq[(int)token-97]++;
        }
       
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<26;i++){
            if(freq[i]!=0)
                pq.add(freq[i]);
        }

        int totalKeys = 8;
        int noOfMappings = 0 ;
        int currentKeyPress = 0;
        int noOfKeyPresses = 0;

        while(!pq.isEmpty()) {
            noOfMappings++;
            currentKeyPress = (int)Math.ceil(noOfMappings/(double)totalKeys);
            int frequency = pq.poll();
            noOfKeyPresses+= currentKeyPress*frequency;
        }

        return noOfKeyPresses;
    }
}
/*

    i-
 */