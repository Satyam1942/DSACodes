class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> freq = new HashMap<>();
        int length = s.length();
        for(int i=0;i<length;i++){
            char token = s.charAt(i);
            freq.put(token,freq.getOrDefault(token,0)+1);
        }

        int maxLength = 0;
        boolean flag = false;
        for(Map.Entry<Character,Integer> i: freq.entrySet()){
            int val = i.getValue();
            if(val%2==0)
                maxLength+=val;
            else{
                maxLength+=val-1;
                flag = true;
            }
        }

        if(flag)
            maxLength++;
        return maxLength;
    }
}