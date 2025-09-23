class Solution {
    public String maximumBinaryString(String binary) {
        int length = binary.length();
        int zeroCount = 0;
        int oneCount = 0;
        int firstIndexZero = -1;
        for(int i=0;i<length;i++) {
            char token = binary.charAt(i);
            if(token == '0') {
                if(firstIndexZero==-1) {
                    firstIndexZero = i;
                }
                zeroCount++;
            } else {
                if(firstIndexZero!=-1) {
                    oneCount++;        
                }
            }
        } 

        if(zeroCount<2) {
            return binary;
        }

        int newLength = binary.length()-firstIndexZero;
        int specialIndex = -1;
        for(int i = 1; i<length; i++) {
            if(binary.charAt(i)=='1' && binary.charAt(i-1)=='0') {
                specialIndex = firstIndexZero + newLength-oneCount-1;
                break;
            }
        }

        int setBitCount = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++) {
            sb.append('1');
        }

        if(specialIndex == -1) {
            specialIndex = length-1;
        }

        sb.setCharAt(specialIndex, '0');

        return sb.toString();
    }
}

/*
    000101100
    111110111
*/