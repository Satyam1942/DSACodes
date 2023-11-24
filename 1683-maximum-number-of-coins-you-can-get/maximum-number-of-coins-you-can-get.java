class Solution {
    public int maxCoins(int[] piles) {
       int size = piles.length;
       int noOfTurns = size/3;
       int maxElement = Integer.MIN_VALUE;
       for(int i=0;i<piles.length;i++) maxElement = Math.max(maxElement, piles[i]);

       int freq[] = new int[maxElement+1];
       for(int i=0;i<size;i++) freq[piles[i]]++;

        int j = maxElement;
        boolean myChance = false;
        int coins = 0; 

       while(noOfTurns>0)
       {
           if(myChance) { coins+=j; noOfTurns--; }
            freq[j]--;
            while(freq[j]==0) j--;
            myChance = !myChance;      
       }

        return coins;

    }
}
/*
1-1
2-2
3-1
4-1
5-1
6-1
7-1
8-1
9-1
 */