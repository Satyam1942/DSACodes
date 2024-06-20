class Solution {
    public int longestValidParentheses(String s) {
        int length = s.length();
        Stack<Integer> st = new Stack<>();
        int left =0;
        int right = 0;
        int maxLength = 0;
        while(right<length){
            char token = s.charAt(right);
            if(token==')'){
               if(st.isEmpty()){
                left = right+1;
               }else{
                st.pop();
                int prevIndex = (st.isEmpty()) ? -1:st.peek();
                if(prevIndex==-1){
                    maxLength = Math.max(maxLength,right-left+1);
                }else{
                    maxLength = Math.max(maxLength,right-prevIndex);
                }
               }
            }else{
                st.push(right);
            }
            right++;
        }

        return maxLength;
    }
}