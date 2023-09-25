class Solution {
    public char findTheDifference(String s, String t) {
        /*
        a-1
        b-1
        c-1
        d-1
         */
         HashMap<Character, Integer> map = new HashMap<>();
         for(int i=0;i<s.length();i++)
         {
             map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
         }

         for(int i=0;i<t.length();i++)
         {
             if(map.isEmpty()) 
             {
                return t.charAt(i);
             }

             if(map.containsKey(t.charAt(i)))
             {
                 if(map.get(t.charAt(i))==1) map.remove(t.charAt(i));
                 else map.put(t.charAt(i), map.get(t.charAt(i))-1);
             }
             else  return t.charAt(i);
         }

         return '\0';
    }
}