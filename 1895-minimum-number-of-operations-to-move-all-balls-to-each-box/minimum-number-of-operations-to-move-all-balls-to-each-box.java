class Solution {
    public int[] minOperations(String boxes) {
        int length = boxes.length();
        int forwardArray[] = new int[length];
        int backwardArray[] = new int[length];
        int operationCount[] = new int[length];
        int count = 0;
        int delta = 0;

        for(int i=0;i<length;i++) {
            char token = boxes.charAt(i);
            forwardArray[i] = count;
            if(token=='1') {
                delta+=1;
            } 
            count+=delta;
        }

        count = 0;
        delta = 0;
        for(int i=length-1;i>=0;i--) {
            char token = boxes.charAt(i);
            backwardArray[i] = count;
            if(token=='1') {
                delta+=1;
            } 
            count+=delta;
        }

        for(int i=0;i<length;i++) {
            operationCount[i] = forwardArray[i]+backwardArray[i];
        }

        return operationCount;
    }
}

/*
    001011
    
    110
    013
    100
*/