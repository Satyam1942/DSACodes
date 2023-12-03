class Solution {
 
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int j = 0;
        long prefixSum = 0l;
        int additionalCoins = 0;

        for(int i=1;i<=target;i++)
        {
            while(j<coins.length && coins[j]<=i)
            {
                prefixSum+=(long)coins[j];
                j++;
            }

            if(i>prefixSum)
            {
                prefixSum+=(long)i;
                additionalCoins++;
            }
        }
        
        return additionalCoins;
    }
}