class Solution {
    public boolean canConstruct(String s, int k) {
        int length = s.length();
        int freq[] = new int[26];
        int oddFreqCount = 0;

        for(int i=0; i<length; i++) {
            char token = s.charAt(i);
            freq[(int)token-97]++;
        }

        for(int i=0;i<26;i++) {
            if(freq[i]%2!=0) {
                oddFreqCount++;
            }
        }

        if(oddFreqCount>k || k>length) {
            return false;
        }

        return true;
    }
}

/*
    a-2
    b-1
    e-2
    l-2
    n-2

    odd = 1
    so if no of characters having odd frequency  more than than k (say x)
    or k>length of string
    else
        return true;
*/