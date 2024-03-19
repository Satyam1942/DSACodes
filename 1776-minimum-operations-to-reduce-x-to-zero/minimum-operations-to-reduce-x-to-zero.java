class Solution {
    int getSum(int arr[] ,int length){
        int sum = 0;
        for(int i=0;i<length;i++){
            sum+=arr[i];
        }
        return sum;
    }

    public int minOperations(int[] nums, int x) {
        int length = nums.length;
        int totalSum = getSum(nums,length);
        
        if(x>totalSum)
            return -1;
        if(x==totalSum)
            return length;

        int i=0,j=0;
        int expectedSum = totalSum-x;
        int runningSum = 0;
        int maximumSubarrayLength = 0;

        while(i<=j && j<=length){
            if(runningSum>expectedSum){
                runningSum-=nums[i];
                i++;
                continue;
            }else if(runningSum==expectedSum){
                maximumSubarrayLength = Math.max(maximumSubarrayLength,j-i);
            }

            if(j<length)
                runningSum+=nums[j];
            j++;
        }

        if(maximumSubarrayLength==0)
            return -1;

        return length-maximumSubarrayLength;
    }
}

/*
    sum = 11
    find longest subarray with sum = sum-x = 11-5 = 6
    1,1,4,2,3
          i   j 
    runningSum = 6
    length = 3
    ans = 5-3 =2
 */
