class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        int length = s.length();
        for(int i=0;i<length;i++){
            char token = s.charAt(i);
            if(token>=97 && token<=122){
                st.push(token);
            }else{
                st.pop();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}