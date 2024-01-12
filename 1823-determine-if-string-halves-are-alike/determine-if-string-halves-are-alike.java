class Solution {
    boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||
               ch=='A' ||ch=='E'||ch=='I'||ch=='O'||ch=='U';
    }

    public boolean halvesAreAlike(String s) {
        int count = 0;
        int length = s.length();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(i>=length/2 && isVowel(ch)) count--;
            else if(isVowel(ch)) count++;
        }

        return count==0;
    }
}