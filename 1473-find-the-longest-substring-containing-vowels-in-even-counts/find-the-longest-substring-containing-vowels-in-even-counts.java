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
    32 = -1  
    23 = 0
    23
    0- 1,0,1,1,1        
    1- 1,0,1,1,1 
    2- 1,1,1,1,1
    
    using hashmap of integer , integer (bit mask)
    in bit mask  if all bits are set it means all are even ; ie if number is 31
    and for each vowel toggle the bit

   maxLength = 3
 */