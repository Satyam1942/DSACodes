class Solution {
    int minimumCuts(int index, String s, boolean palindromeCache[][], Integer cache[]){
        
        if(index>=s.length()-1)
            return 0;

        if(cache[index]!=null)
            return cache[index];

        int minCuts = Integer.MAX_VALUE;
        for(int k=index;k<s.length();k++){
            if(palindromeCache[index][k]){
                int temp = minimumCuts(k+1,s,palindromeCache,cache);
                if(k+1!=s.length())
                    temp++;
                minCuts = Math.min(minCuts,temp);
            }
        }
        return cache[index] = minCuts;
    }

    public int minCut(String s) {
        int length = s.length();
        boolean palindromeCache[][] = new boolean[length][length];
    
        for(int center = 0; center<s.length();center++){
            int leftOdd = center;
            int rightOdd = center;
            while(leftOdd>=0 && rightOdd<length) {
                if(s.charAt(leftOdd)==s.charAt(rightOdd))
                    palindromeCache[leftOdd][rightOdd] = true;
                else{
                    palindromeCache[leftOdd][rightOdd] = false;
                    break;
                }
                leftOdd--;
                rightOdd++;
            }

            int leftEven  = center;
            int rightEven = center+1;
            while(leftEven>=0 && rightEven<length){
                if(s.charAt(leftEven)==s.charAt(rightEven))
                    palindromeCache[leftEven][rightEven] = true;
                else{
                    palindromeCache[leftEven][rightEven] = false;
                    break;
                }
                leftEven--;
                rightEven++;
            }
        }
        
        Integer cache[] = new Integer[length];
        return minimumCuts(0,s,palindromeCache,cache);
    }
}