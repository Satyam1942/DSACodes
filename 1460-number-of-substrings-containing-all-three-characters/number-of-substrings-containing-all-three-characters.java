class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0;
        int right = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int length = s.length();
        int count = 0;
        while(left<=right && right<=length){
            if(map.size()==3){
                count += length-right+1;
                int freq = map.get(s.charAt(left));
                if(freq==1)
                    map.remove(s.charAt(left));
                else
                    map.put(s.charAt(left),freq-1);
                left++;
                continue;
            }

            if(right<length){
                char token = s.charAt(right);
                int freq=  map.getOrDefault(token,0);
                map.put(token,freq+1);
            }
            right++;
        }

        return count;
    }
}

/* 
          r
    abcabc
       l

    a,c,b
    4+3+2+1
*/