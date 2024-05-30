class Solution {
    public int longestValidParentheses(String s) {
       Stack<Integer> st = new Stack<>();

       int length = s.length();
       int left = 0, right = 0;
       int maxSubstringLength = 0;

        while(right<length){
            char token = s.charAt(right);
            if(token==')'){
                if(st.isEmpty())
                    left = right+1;
                else{
                    st.pop();
                    int curLength =0; 
                    if(st.isEmpty()){
                        curLength = right-left+1;
                    }else
                        curLength = right-st.peek();
                        
                    maxSubstringLength = Math.max(maxSubstringLength, curLength);
                }

            }else
                st.push(right);
            right++;
        }

       return maxSubstringLength;

    }
}

/*
    (())))()()(())
    ()()
    (())
    ()()(()()()

 */