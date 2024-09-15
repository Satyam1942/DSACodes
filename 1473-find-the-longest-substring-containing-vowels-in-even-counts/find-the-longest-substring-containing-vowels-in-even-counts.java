class Solution {

    boolean isVowel(char token) {
        return token == 'a' || token == 'e' || token == 'i' || token =='o' || token == 'u';
    }

    void initialiseBitMaskPos(HashMap<Character,Integer> bitMaskPos) {
        bitMaskPos.put('a',4);
        bitMaskPos.put('e',3);
        bitMaskPos.put('i',2);
        bitMaskPos.put('o',1);
        bitMaskPos.put('u',0);
    }

    public int findTheLongestSubstring(String s) {
        final int evenCheckConstant = 32;
        int length = s.length();

        HashMap<Integer,Integer> mapSubstring = new HashMap<>();
        HashMap<Character,Integer> bitMaskPos = new HashMap<>();

        mapSubstring.put(evenCheckConstant,-1);
        initialiseBitMaskPos(bitMaskPos);

        int mask = evenCheckConstant;
        int maxSubStrLength = 0;

        for(int i=0;i<length;i++) {
            char token = s.charAt(i);
            if(isVowel(token)) {
                int bitPos = bitMaskPos.get(token);
                mask = mask^(1<<bitPos);
            }

            if(mapSubstring.containsKey(mask)) {
                maxSubStrLength = Math.max(maxSubStrLength,i-mapSubstring.get(mask));
            }else
                mapSubstring.put(mask,i);
        }

        return maxSubStrLength;
    }
}

/*
   eleetminicoworoep
       a e i o u

    using hashmap to map integer with integer
    first is hashing number which maps with  the first index where we got that hashing number
    32 = -1  
    23 = 0
    23
    0- 1,0,1,1,1        
    1- 1,0,1,1,1 
    2- 1,1,1,1,1
    
    using hashmap of integer , integer (bit mask)
    in bit mask  if all bits are set it means all are even ; ie if number is 31
    and for each vowel toggle the bit (using xor operator)

    if(the value is in map just subtract with index to get max length)
    else add it to hashmap

    why it works whenver same number comes it means the number of vowels in between 
    were all zero ; ie no change happened to all bits

 */