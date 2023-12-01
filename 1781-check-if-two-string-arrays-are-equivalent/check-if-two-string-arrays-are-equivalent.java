class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i=0,j=0,k=0,l=0;
        while(i<word1.length && j<word2.length)
        {
            
            while(k<word1[i].length() && l<word2[j].length())
            {
                if(word1[i].charAt(k) != word2[j].charAt(l)) return false;
                k++;
                l++;
            }
            if(l==word2[j].length()) {l=0; j++;}
            if(k==word1[i].length()) {k=0;i++;}
        }

        if(i!=word1.length || j!=word2.length) return false;
        
        return true; 
    }
}