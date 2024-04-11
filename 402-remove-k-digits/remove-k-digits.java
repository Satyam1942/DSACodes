class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<num.length();i++){
            char token = num.charAt(i);
            int digit = (int)token-48;
            while(!st.isEmpty() && k>0 && st.peek()>digit){
                st.pop();
                k--;
            }
            st.push(digit);
        }   

        while(k-->0){
            st.pop();
        }

        
        if(st.isEmpty())
            return "0";
        
        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();

        int endZeroIndex = -1;
        for(int i=0;i<sb.length()-1;i++){
            if(sb.charAt(i)!='0')
                break;
            endZeroIndex = i;
        }

        if(endZeroIndex!=-1)
            sb.replace(0,endZeroIndex+1,"");

        return sb.toString();
    }
}


/*
    1 2 1 9
 */