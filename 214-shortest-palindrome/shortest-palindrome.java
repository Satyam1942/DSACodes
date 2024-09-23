class Solution {
    void computeForwardHash(String s, long forwardHash[]) {
        int length = s.length();
        long base = 29;
        long mod = (long)(1e9+7);

        for(int i=0; i<length; i++) {
            char token = s.charAt(i);
            int index = (int)token-97;
            forwardHash[i] = (i==0)? index : (forwardHash[i-1]*base + index)%mod;
        }
    }

    void computeBackwardHash(String s, long backwardHash[]) {
        int length = s.length();
        long base = 29;
        long power = 1;
        long mod = (long)(1e9+7);

        for(int i=0; i<length; i++) {
            char token = s.charAt(i);
            int index = (int)token-97;
            backwardHash[i] = (i==0)? index : (backwardHash[i-1] + index*power)%mod;
            power = (power*base)%mod;
        }
    }

    int getLongestPalindromicPrefixIndex(long forwardHash[] , long backwardHash[]) {
        int length = forwardHash.length;
        int maxIndex = 0;
        for(int i=0; i<length; i++) {
            if(forwardHash[i]==backwardHash[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public String shortestPalindrome(String s) {
        int length = s.length();
        if(length==0 || length==1)
            return s;

        long forwardHash[] = new long[length];
        long backwardHash[] = new long[length];

        computeForwardHash(s, forwardHash);
        computeBackwardHash(s, backwardHash);

        int prefixIndex = getLongestPalindromicPrefixIndex(forwardHash, backwardHash);
        StringBuilder shortestPalindrome = new StringBuilder(s.substring(prefixIndex+1));

        shortestPalindrome.reverse();
        shortestPalindrome.append(s);

        return shortestPalindrome.toString();
    }
}

/*
    a a  c   e c  a     a        a
    1 11 113 1135 11351 113511   1135111

    aa a        c      e        c      a      a
              35311   5311     311     11     1 

*/