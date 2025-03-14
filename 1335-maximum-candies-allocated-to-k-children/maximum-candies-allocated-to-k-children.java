class Solution {
    boolean isPossible( int candies[], long chosenMax, long k) {
        int length = candies.length;
        long noOfChildren = 0;
        for(int i=0; i<length; i++) {
            noOfChildren += candies[i]/chosenMax;
        }
        return noOfChildren>=k;
    }

    long getSum(int candies[]) {
        int length = candies.length;
        long sum = 0;
        for(int i=0; i<length; i++) {
            sum+= candies[i];
        }
        return sum;
    }

    public int maximumCandies(int[] candies, long k) {
        long left = 1;
        long right = getSum(candies)/k;
        long maxCandies = 0;

        while(left<=right) {
            long mid = (left+right)/2;
            if(isPossible(candies, mid, k)) {
                left = mid+1;
                maxCandies = mid;
            } else {
                right = mid-1;
            }
        }

        return (int)maxCandies;
    }
}

/*
    5, 6, 8
    k = 3
    total = 19
    min  = 0
    max = 6
    
    for getting max = divide candies[i]/curMax


*/