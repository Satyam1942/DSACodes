class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;
        int prefixSum[] = new int[length];
        int sum =0;
        for(int i=0;i<length;i++) 
        {
            sum+= cardPoints[i]; 
            prefixSum[i]=sum; 
        }

        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<k;i++)
        {
            int sumOne = prefixSum[i];
            int sumTwo = sum-prefixSum[length-k+i];
            maxi = Math.max(maxi,sumOne+sumTwo);
        }

        if(k<length) maxi = Math.max(maxi,sum-prefixSum[length-k-1]);
        
        return maxi;

    }
}