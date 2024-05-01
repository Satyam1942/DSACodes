class Solution {
    public String reversePrefix(String word, char ch) {
        boolean flag = false;
        int length = word.length();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<length;i++){
            char token = word.charAt(i);
            sb.append(token);
            if(token==ch && !flag){
                flag = true;
                sb.reverse();
            }
        }

        return sb.toString();
    }
}