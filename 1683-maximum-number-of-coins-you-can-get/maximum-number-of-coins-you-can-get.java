class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i = piles.length-2,j=0;
        int maxCoins = 0;
        while(i>j)
        {
            maxCoins+=piles[i];
            i-=2;
            j++;
        }
        return maxCoins;
    }
}

/*
     2 3 4 5 6 7 
    1 2 2 4 7 8
 */