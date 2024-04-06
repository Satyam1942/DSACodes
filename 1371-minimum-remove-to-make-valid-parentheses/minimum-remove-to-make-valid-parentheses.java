class Solution {
    public String minRemoveToMakeValid(String s) {
        int length = s.length();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < length; i++) {
            char token = s.charAt(i);
            if (token == '(')
                st.push(i);
            else if (token == ')') {
                if (st.isEmpty() || s.charAt(st.peek()) != '(')
                    st.push(i);
                else
                    st.pop();
            }
        }

        StringBuilder parenthesisedString = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            char token = s.charAt(i);
            if (!st.isEmpty() && st.peek() == i) {
                st.pop();
                continue;
            }
            parenthesisedString.append(token);
        }

        parenthesisedString.reverse();
        return parenthesisedString.toString();

    }
}