class Solution {
    public int minLength(String s) {
        int length = s.length();
        Stack<Character> st =  new Stack<>();
        for(int i=0;i<length;i++) {
            char token = s.charAt(i);
            boolean canPop = st.size()>0 && ((token=='B' && st.peek()=='A') || (token=='D' && st.peek()=='C'));
            if(canPop) {
                st.pop();
            } else {
                st.push(token);
            }
        }
        return st.size();
    }
}