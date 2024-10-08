class Solution {
    public int minSwaps(String s) {
        int length = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<length;i++) {
            char token = s.charAt(i);
            if(token==']') {
                if(!st.isEmpty() && st.peek()=='[') {
                    st.pop();
                }
            }
            else {
                st.push('[');
            }
        }

        int count = 0;
        while(!st.isEmpty()) {
            if(st.peek()=='[') {
                count++;
            }
            st.pop();
        }
        return (int) Math.ceil(count/2.0);
    }
}

/*
    ]]][[[
 1=>[]][[]
 2=>[][][]  
  
   ][[]][

*/