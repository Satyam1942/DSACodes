class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String wd1 = "",wd2 = "";
        for(int i=0;i<word1.length;i++) wd1+=word1[i];
        for(int i=0;i<word2.length;i++) wd2+=word2[i];
        return wd1.equals(wd2);
        
    }
}