class Solution {
    void calculateFrequency(String word, int freq[]){
        int length = word.length();
        for(int i=0;i<length;i++){
            char token = word.charAt(i);
            freq[(int)token-97]++;
        }
    }

    void orderByFrequency(int freq[], PriorityQueue<Integer> pq){
         for(int i=0;i<26;i++){
            if(freq[i]!=0)
                pq.add(freq[i]);
        }
    }

    public int minimumPushes(String word) {
        
        int freq[] = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        calculateFrequency(word,freq);
        orderByFrequency(freq,pq);

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