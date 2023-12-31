class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int length = -1;
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                int prevIndex = map.get(s.charAt(i));
                length = Math.max(length,i-prevIndex-1);
            }
            else map.put(s.charAt(i),i);
        }

        return length;
    }
}