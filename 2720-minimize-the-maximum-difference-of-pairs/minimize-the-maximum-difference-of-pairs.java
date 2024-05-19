class Solution {
    boolean isPossible(int minDif, int pairCount, int[]nums){
        int length = nums.length;
        int noOfPairs = 0;
        for(int i=0;i<length-1;i++){
            if(nums[i+1]-nums[i]<=minDif){
                i++;
                noOfPairs++;
            }
        }
        return noOfPairs>=pairCount;
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int length = nums.length;
        int left = 0;
        int right = nums[length-1]-nums[0];
        int ans = right;

        while(left<=right){
            int mid = (left+right)/2;
            if(isPossible(mid,p,nums)){
                ans = mid;
                right = mid-1;
            }else
                left = mid+1;
        }  
        return ans;
    }
}

/*
    1,1,2,3,7,10

 */