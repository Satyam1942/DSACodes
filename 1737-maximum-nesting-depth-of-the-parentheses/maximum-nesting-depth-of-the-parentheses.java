class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int top = 0;
        int length = s.length();

        for(int i=0;i<length;i++){
            char token = s.charAt(i);
            if(token=='('){
                top++;
            }
            else if(token==')'){
                top--;
            }
            maxDepth = Math.max(maxDepth,top);
        }

        return maxDepth;
    }
}