class Solution {
    public int minAddToMakeValid(String s) {
        int length = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<length;i++) {
            char token = s.charAt(i);
            if(token==')') {
                if(!st.isEmpty() && st.peek()=='(') {
                    st.pop();
                } else {
                    st.push(')');
                }
            } else {
                st.push('(');
            }
        }

        return st.size();
    }
}