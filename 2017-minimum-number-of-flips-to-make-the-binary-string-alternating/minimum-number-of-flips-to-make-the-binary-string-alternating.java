class Solution {
    public int minFlips(String s) {
        int length = s.length();
        int zeroOneChange[] = new int[length];
        int prefixSumZeroOne[]  = new int[length];
        int oneZeroChange[] = new int[length];
        int prefixSumOneZero[]  = new int[length];
        int bitArr[] = new int[length];
        int minCount = Integer.MAX_VALUE;

        for(int i=0;i<length; i++) {
            char token = s.charAt(i);
            int bit = (int)token-48;
            bitArr[i] = bit;
        }

        //start From Zero
        int cur = 0;
        for(int i=0; i<length; i++) {
            if(cur!=bitArr[i]) {
                zeroOneChange[i] = 1;
            }
            cur = 1-cur;
        }

        prefixSumZeroOne[0] = zeroOneChange[0];
        for(int i=1;i<length;i++) {
            prefixSumZeroOne[i] = prefixSumZeroOne[i-1]+zeroOneChange[i];
        }

        // start from one
        cur = 1;
        for(int i=0; i<length; i++) {
            if(cur!=bitArr[i]) {
                oneZeroChange[i] = 1;
            }
            cur = 1-cur;
        }
        
        prefixSumOneZero[0] = oneZeroChange[0];
        for(int i=1;i<length;i++) {
            prefixSumOneZero[i] = prefixSumOneZero[i-1]+oneZeroChange[i];
        }


        if(length%2==0) {
            int zeroOne = prefixSumZeroOne[length-1];
            int oneZero = prefixSumOneZero[length-1];
            int curCount = Math.min(zeroOne, oneZero);
            minCount = Math.min(curCount, minCount);                
        } else {
            for(int i=0;i<length; i++) {
                int zeroOne = (i==0)? prefixSumZeroOne[length-1] : prefixSumZeroOne[length-1]-prefixSumZeroOne[i-1]+prefixSumOneZero[i-1];
                int oneZero = (i==0)? prefixSumOneZero[length-1] : prefixSumOneZero[length-1]-prefixSumOneZero[i-1]+prefixSumZeroOne[i-1];
                int curCount = Math.min(zeroOne, oneZero);
                minCount = Math.min(curCount, minCount);                
            }
        }
        
        return minCount;
    }
}
/*
    
 */