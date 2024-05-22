class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        long prefixSum = 0;
        int j =0;
        int additionalCoins = 0;
        for(int i=1;i<=target;i++){
            while(j<coins.length && coins[j]<=prefixSum+1){
                prefixSum+=coins[j];
                j++;
            }
            if(i>prefixSum){
                prefixSum+=i;
                additionalCoins++;
            }
        }
        return additionalCoins;
    }
}

/*
    WHY DOES IT WORK? 
    If you are able to form prefix sum  = j ;
    then  you can form all numbers from 1 to j till you encounter number > prefixSum+1
 */