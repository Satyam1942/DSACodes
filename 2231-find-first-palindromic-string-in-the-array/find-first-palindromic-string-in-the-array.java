class Solution {
    boolean isPalindrome(String str){
        int i=0,j=str.length()-1;
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }   
        return true;
    }
    public String firstPalindrome(String[] words) {
        int length = words.length;
        for(int i=0;i<words.length;i++){
            if(isPalindrome(words[i]))
                return words[i];
        }
        return "";
    }
}