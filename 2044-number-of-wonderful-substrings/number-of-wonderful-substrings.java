/*
    HINT !! Not a Sliding window  rather A bit manipulation problem!!
 */
class Solution {
    public long wonderfulSubstrings(String word) {
        
        int length = word.length();
        HashMap<Integer,Integer> bitmasks = new HashMap<>();
        bitmasks.put(0,1);

        long count = 0;
        int mask = 0;
        
        for(int i=0;i<length;i++){
            char token = word.charAt(i);
            int index = (int)token-97;
            mask = mask^(1<<index);

            int curFreq = bitmasks.getOrDefault(mask,0);
            count+= curFreq;

            for(int j=0;j<10;j++){
                int newBitMask = mask^(1<<j);
                count+= bitmasks.getOrDefault(newBitMask,0);
            }

            bitmasks.put(mask,curFreq+1);      
        }

        return count;
    }
}

/*
    aba
    i
      j

    a,b
    count = 2

 */