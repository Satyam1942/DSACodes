class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        char arrS[] = s.toCharArray();
        char arrT[] = t.toCharArray();

        Arrays.sort(arrS);
        Arrays.sort(arrT);

        int i=0;
        while(i<s.length())
        {
            if(arrS[i]!=arrT[i]) return false;
            i++;
        }
        
        return true;
    }
}