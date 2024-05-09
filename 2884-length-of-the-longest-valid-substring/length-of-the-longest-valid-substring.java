class Solution {
    int checkIfValid(int i, int j, String s, HashSet<String> dictionary, int maxLength){
        StringBuilder sb = new StringBuilder ();
        for(int k=j;k>=i && (j-k)<maxLength;k--){
            sb.append(s.charAt(k));
            StringBuilder rev = new StringBuilder(sb);
            rev.reverse();
            if(dictionary.contains(rev.toString()))
                return k;
        }
        return -1;
    }

    public int longestValidSubstring(String word, List<String> forbidden) {
        HashSet<String> dictionary = new HashSet<>();
        int maxLengthOfForbidden = 0;

        for(int i=0;i<forbidden.size();i++){
            dictionary.add(forbidden.get(i));
            maxLengthOfForbidden = Math.max(maxLengthOfForbidden,forbidden.get(i).length());
        }

        int length = word.length();
        int i =0 ,j=0;
        int validSubstringLength = 0;

        while(i<=j && j<length){
            int val = checkIfValid(i,j,word,dictionary, maxLengthOfForbidden);
            if(val!=-1){
                i = val+1;
            }
            validSubstringLength = Math.max(validSubstringLength, j-i+1);
            j++;
        }

        return  validSubstringLength;
    }
}
/*
    cbaaabc
    
*/