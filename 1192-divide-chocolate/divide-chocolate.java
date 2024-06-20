class Solution {
    boolean isPossible(int minSweetnessValue ,int targetPartitions,int sweetness[]){
        int length = sweetness.length;
        int sumOfSweetnessValue = 0;
        int noOfPartitions = 0;
        for(int i=0;i<length;i++){
            sumOfSweetnessValue+=sweetness[i];
            if(sumOfSweetnessValue>=minSweetnessValue){
                noOfPartitions++;
                sumOfSweetnessValue = 0;
            }
        }
        return noOfPartitions>=targetPartitions;
    }
    int getMin(int sweetness[]){
        int length = sweetness.length;
        int minVal = Integer.MAX_VALUE;

        for(int i=0;i<length;i++)
            minVal = Math.min(minVal,sweetness[i]);
        return minVal;
    }

    int getSum(int sweetness[]){
        int length = sweetness.length;
        int sum = 0;

        for(int i=0;i<length;i++)
            sum+=sweetness[i];

        return sum;
    }

    public int maximizeSweetness(int[] sweetness, int k) {
      int left = getMin(sweetness);
      int right = getSum(sweetness);
      int maxSweetness = left;

      while(left<=right){
        int mid = (left+right)/2;
        if(isPossible(mid,k+1,sweetness)){
            left = mid+1;
            maxSweetness = mid;
        }else
            right = mid-1;
      }  
        return maxSweetness;
    }
}
/*
    left = 7
    right = 12
    mid = 6

 */