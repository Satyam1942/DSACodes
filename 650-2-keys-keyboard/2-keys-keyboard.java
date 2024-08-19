class Solution {

    int createString(int charactersCopied, int currentLength, int targetLength, Integer cache[][]) {
        if(currentLength==targetLength)
            return 0;

        if(cache[charactersCopied][currentLength]!=null)
            return cache[charactersCopied][currentLength];

        int copyAdditionalCharacters = Integer.MAX_VALUE;
        int pasteAdditionalCharacters = Integer.MAX_VALUE;
        
        if(charactersCopied<currentLength)
            copyAdditionalCharacters = createString(currentLength, currentLength, targetLength, cache);

        if(charactersCopied>0 && currentLength+charactersCopied<=targetLength)
            pasteAdditionalCharacters = createString(charactersCopied, currentLength+charactersCopied, targetLength, cache);
        

        if(copyAdditionalCharacters!=Integer.MAX_VALUE)
            copyAdditionalCharacters++;
            
        if(pasteAdditionalCharacters!=Integer.MAX_VALUE)
            pasteAdditionalCharacters++;
       
        return cache[charactersCopied][currentLength] = Math.min(copyAdditionalCharacters,pasteAdditionalCharacters);
    }

    public int minSteps(int n) {
        Integer cache[][] = new Integer[n+1][n+1];
        int minMoves =  createString(0,1,n,cache);
        return minMoves;
    }
}

/*
    A
    charactersCopied, currentLength
 */