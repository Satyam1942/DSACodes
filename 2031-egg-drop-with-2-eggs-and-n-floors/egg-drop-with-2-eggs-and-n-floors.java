class Solution {
    int dropEgg(int n, int noOfEggs, Integer cache[][]){
        if(noOfEggs==1)
            return n;
        if(n<=1)
            return n;
        if(cache[n][noOfEggs]!=null)
            return cache[n][noOfEggs];

        int minMoves = Integer.MAX_VALUE;
        for(int floor = 1;floor<=n;floor++){
            int eggBreaks = dropEgg(floor-1,noOfEggs-1,cache);
            int eggNotBreaks = dropEgg(n-floor,noOfEggs,cache);
            int curMoves = Math.max(eggBreaks,eggNotBreaks)+1;
            minMoves = Math.min(minMoves,curMoves);
        }
        return cache[n][noOfEggs] = minMoves;
    }

    public int twoEggDrop(int n) {
        Integer cache[][] = new Integer[n+1][3];
        return dropEgg(n,2,cache);
    }
}