class Solution {
    public int numberOfSubstrings(String s) {
        int i = 0;
        int j = 0;
        int length = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int substrCount = 0;

        while(j<=length) {
            if(map.size()==3) {
                substrCount+= length-j+1;
                char prevToken = s.charAt(i);
                int freq = map.get(prevToken);
                if(freq==1) {
                    map.remove(prevToken);
                } 
                else {
                    map.put(prevToken, freq-1);
                }

                i++;
                continue;
            }

            if(j<length) {
                char token = s.charAt(j);
                int curFreq = map.getOrDefault(token,0);
                map.put(token, curFreq+1);
            }
            j++;
        }
        return substrCount;
    }
}

/*
    abcabc
    4+3+2+1
*/