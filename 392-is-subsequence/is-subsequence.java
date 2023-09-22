class Solution {
    public boolean isSubsequence(String s, String t) {
        int left=0 ,right = 0;

        while(left<s.length() && right<t.length())
        {
            if(s.charAt(left)==t.charAt(right)) left++;
            right++;
        }
        return left == s.length();
    }
}