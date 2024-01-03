class Solution {
    public String decodeString(String encoded) {
        Stack<String> st = new Stack<>();
        int length = encoded.length();
        String decoded = "";
        for (int i = 0; i < length; i++) {
            char token = encoded.charAt(i);
            if (token == ']') {
                String temp = "";
                while (!st.peek().equals("["))
                    temp = st.pop() + temp;
                st.pop();
                String newStr = "";
                String repeat = "";
                while(!st.isEmpty() && st.peek().charAt(0)>=48 && st.peek().charAt(0)<=57)  
                    repeat = st.pop()+repeat;
                int timesToRepeat = Integer.valueOf(repeat);
                while (timesToRepeat >0) {
                    newStr += temp;
                    timesToRepeat--;
                }
                st.push(newStr);
            } else st.push(String.valueOf(token));
            // System.out.println(st);
        }

        while (!st.isEmpty())
            decoded = st.pop() + decoded;

        return decoded;

    }
}