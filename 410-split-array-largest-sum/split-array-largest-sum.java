class Solution {
    int sumOfArray(int nums[]){
        int length = nums.length;
        int sum = 0;
        for(int i=0;i<length;i++)
            sum+=nums[i];
        return sum;
    }
    int maxOfArray(int nums[]){
        int length = nums.length;
        int max = 0;
        for(int i=0;i<length;i++)
            max=Math.max(nums[i],max);
        return max;
    }

    boolean isPossible(int nums[], int k, int maxSum){
        int curSum = 0;
        int length = nums.length;
        int partition = 0;
        for(int i=0;i<length;i++){
            curSum+=nums[i];
            if(curSum>maxSum){
                curSum = nums[i];
                partition++;
            }
        }
        return partition<=k-1;
    }

    public int splitArray(int[] nums, int k) {
        int left =  maxOfArray(nums);
        int right =  sumOfArray(nums);
        int minSum = right;
        while(left<=right){
            int mid = (left+right)/2;
            if(isPossible(nums,k,mid)){
                minSum = mid;
                right = mid-1;
            }else
                left = mid+1;
        }  
        return minSum;
    }
}