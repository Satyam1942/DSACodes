class Solution {
    public boolean checkValidString(String s) {
        int length = s.length();
        int openCountMin =0, openCountMax = 0;
        for(int i=0;i<length;i++){
            char token = s.charAt(i);
            if(token=='('){
                openCountMin++;
                openCountMax++;
            }else if(token==')'){
                openCountMin--;
                openCountMax--;
            }else if(token=='*') {
                openCountMax++;
                openCountMin--;
            }

            if(openCountMax<0)
                return false;
                
            openCountMin  = Math.max(openCountMin,0);
        }

        return openCountMin==0;
    }
}

/*

*/