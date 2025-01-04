class Solution {
    public int countPalindromicSubsequence(String s) {
        int length = s.length();
        int count  = 0;
        HashMap<Character,TreeSet<Integer>> map = new HashMap<>();
        for(int i=0;i<length;i++) {
            char token = s.charAt(i);
            if(!map.containsKey(token)) {
                map.put(token, new TreeSet<>());
            }
            map.get(token).add(i);
        }

        for(int i=0;i<26;i++) {
            char token = (char)(i+97);
            if(!map.containsKey(token)) {
                continue;
            }
            Integer firstIndex = map.get(token).first();
            Integer secondIndex = map.get(token).last();
            if(firstIndex!=null && secondIndex-firstIndex>=2) {
                for(int j=0;j<26;j++) {
                    char token2 = (char)(j+97);
                    if(!map.containsKey(token2)) {
                        continue;
                    }
                    Integer ceilingIndex = map.get(token2).higher(firstIndex);
                    Integer floorIndex = map.get(token2).lower(secondIndex);
                    if(ceilingIndex!=null && floorIndex!=null && ceilingIndex<=floorIndex) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}

/*
   a - (4,0),(6,1)
   b - (0,0),(1,1),(3,2),(5,3)
   c - (2,0)
*/