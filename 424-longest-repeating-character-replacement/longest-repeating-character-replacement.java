class Solution {
    public int characterReplacement(String s, int k) {
     
        int longestSubstring = 0;
        int freq[] = new int[26];
        int maxFreq = 0;
        for(int i=0;i<s.length();i++)
        {
                maxFreq = Math.max(maxFreq,++freq[(int)s.charAt(i)-65]);
                if(longestSubstring-maxFreq+1<=k) longestSubstring++;
                else freq[(int)s.charAt(i-longestSubstring)-65]--;
        }

        return longestSubstring;

    }
}
/*
    A,B
    longestSubstring = 1;
    maxFreq = 1
 */