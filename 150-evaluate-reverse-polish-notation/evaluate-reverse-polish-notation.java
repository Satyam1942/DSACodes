class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int len = tokens.length;
        int count=0;

        int num1 = 0, num2 = 0;
        for(int i =0;i<len;i++)
        {   
            if(tokens[i].equals("+"))
            {
                 num1 = st.pop();
                 num2 = st.pop();
                st.push(num1+num2);
            }
            else if(tokens[i].equals("-"))
            {
                 num1 = st.pop();
                 num2 = st.pop();
                st.push((num2-num1));
            }
            else if(tokens[i].equals("*"))
            {
                 num1 = st.pop();
                 num2 = st.pop();
                 st.push(num1*num2);
            }
            else if(tokens[i].equals("/"))
            {
                 num1 = st.pop();
                 num2 = st.pop();
                 if(num1==0) st.push(0);
                 else st.push(num2/num1);
            }
            else st.push(Integer.parseInt(tokens[i]));
        }

        return st.pop();
    }
}