class Solution {
    int minimumCharacterChanges(int index, int k, String s, int palindromeCache[][], Integer cache[][]) {
    
        if (index >= s.length() - 1) {
            if(k==0)
                return 0;
            else
                return Integer.MAX_VALUE;
        }

        if (k == 0){
            return palindromeCache[index][s.length() - 1];
        }

        if (cache[index][k] != null)
            return cache[index][k];

        int minChanges = Integer.MAX_VALUE;
        for (int j = index; j < s.length()-1; j++) {
            int partition = Integer.MAX_VALUE;
            if (k > 0)
                partition = minimumCharacterChanges(j + 1, k - 1, s, palindromeCache, cache);

            if ( partition != Integer.MAX_VALUE)
                partition += palindromeCache[index][j];
    
            minChanges = Math.min(minChanges, partition);
        }

        return cache[index][k] = minChanges;
    }

    public int palindromePartition(String s, int k) {
        int length = s.length();
        int palindromeCache[][] = new int[length][length];

        for (int center = 0; center < s.length(); center++) {
            int leftOdd = center;
            int rightOdd = center;
            int countOdd = 0;
            while (leftOdd >= 0 && rightOdd < length) {
                if (s.charAt(leftOdd) != s.charAt(rightOdd))
                    countOdd++;
                palindromeCache[leftOdd][rightOdd] = countOdd;
                leftOdd--;
                rightOdd++;
            }

            int leftEven = center;
            int rightEven = center + 1;
            int countEven = 0;
            while (leftEven >= 0 && rightEven < length) {
                if (s.charAt(leftEven) != s.charAt(rightEven))
                    countEven++;
                palindromeCache[leftEven][rightEven] = countEven;
                leftEven--;
                rightEven++;
            }
        }
        // for(int i=0;i<length;i++){
        // for(int j=0;j<length;j++){
        // System.out.print(palindromeCache[i][j]+" ");
        // }
        // System.out.println();
        // }

        Integer cache[][] = new Integer[length][k];
        return minimumCharacterChanges(0, k - 1, s, palindromeCache, cache);
    }
}