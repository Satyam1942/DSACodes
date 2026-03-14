class Solution {
    String recursion(int n, int k, char prevChar) {
        if(n==0) {
            return  "";
        }
        
        StringBuilder sb = new StringBuilder();
        int maxHappyString = (1<<(n));
        int modulus =  k%(maxHappyString/2);
        int region = (modulus == 0)? k/(maxHappyString/2): k/(maxHappyString/2)+1;
        modulus = (modulus==0)? maxHappyString/2 : modulus; 
        char curChar = '\0';

        switch(prevChar) {
            case 'a' :
                if(region == 1) {
                    curChar = 'b';
                } else {
                    curChar =  'c';
                }
                break;
            case 'b' :
                if(region == 1) {
                    curChar = 'a';
                } else {
                    curChar = 'c';
                }
                break;
            case 'c' :
                if(region == 1) {
                    curChar = 'a';
                } else {
                    curChar = 'b';
                }
                break;
        }

        String newStr = recursion(n-1, modulus, curChar);
        sb.append(curChar);
        sb.append(newStr);
        return sb.toString();
    }

    public String getHappyString(int n, int k) {
        int maxHappyString = (1<<(n-1))*3;
        if(k>maxHappyString) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int modulus =  k%(maxHappyString/3);
        int region = (modulus == 0)? k/(maxHappyString/3): k/(maxHappyString/3)+1;
        modulus = (modulus==0)? maxHappyString/3 : modulus; 
        char prevChar = '\0';

        if(region == 1) {
            prevChar = 'a';
        } else if(region == 2) {
            prevChar = 'b';
        } else {
            prevChar = 'c';
        }

        String nStr =  recursion(n-1, modulus, prevChar);
        sb.append(prevChar);
        sb.append(nStr);
        return sb.toString();
    }
}