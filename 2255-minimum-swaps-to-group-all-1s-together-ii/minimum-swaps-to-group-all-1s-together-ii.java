class Solution {
  public int minSwaps(int[] nums) {
    int totalOnes = 0;
    int length = nums.length;
    for(int i=0;i<length;i++){
        totalOnes+=nums[i];
    }

    int oneCountSlidingWindow = 0;
    int maxOneCount =0 ;
    for(int i=0;i<totalOnes;i++){
        oneCountSlidingWindow+=nums[i];
    }

    maxOneCount = oneCountSlidingWindow;
    for(int i = totalOnes;i<totalOnes+length;i++){
        oneCountSlidingWindow += nums[i%length]-nums[(i-totalOnes+length)%length]  ;
        maxOneCount = Math.max(maxOneCount,  oneCountSlidingWindow);
    }

    return totalOnes-maxOneCount;
}
}