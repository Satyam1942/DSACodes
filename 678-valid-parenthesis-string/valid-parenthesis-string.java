class Solution {
    public boolean checkValidString(String language) {
        int length = language.length();
        TreeSet<Integer> starIndex = new TreeSet<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < length; i++) {
            char token = language.charAt(i);
            if (token == '*')
                starIndex.add(i);
            else if (token == '(')
                st.push(i);
            else {
                if (!st.isEmpty()) {
                    if (language.charAt(st.peek()) == '(')
                        st.pop();
                    else
                        st.push(i);
                } else
                    st.push(i);
            }

        }

        List<Integer> wrongParenthesisList = new ArrayList<>();
        while (!st.isEmpty()) {
            wrongParenthesisList.add(st.pop());
        }

        int lengthOfList = wrongParenthesisList.size();
        for (int i = lengthOfList - 1; i >= 0; i--) {
            int index = wrongParenthesisList.get(i);
            char token = language.charAt(index);
            if (token == ')') {
                Integer key = starIndex.floor(index);
                if (key != null)
                    starIndex.remove(key);
                else
                    return false;
            } else {
                Integer key = starIndex.ceiling(index);
                if (key != null)
                    starIndex.remove(key);
                else
                    return false;
            }

        }
        return true;

    }
}