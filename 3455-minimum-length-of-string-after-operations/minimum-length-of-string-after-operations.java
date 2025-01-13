class Solution {
    public int minimumLength(String s) {
        int length = s.length();
        int freq[] = new int[26];
        for(int i=0;i<length;i++) {
            char token = s.charAt(i);
            freq[(int)token-97]++;
        }

        int minLength = 0;
        for(int i=0;i<26;i++) {
            int f = freq[i];
            if(f==0) {
                continue;
            }

            if(f%2==0) {
                minLength+=2;
            } else {
                minLength+=1;
            }
        }

        return minLength;
    }
}