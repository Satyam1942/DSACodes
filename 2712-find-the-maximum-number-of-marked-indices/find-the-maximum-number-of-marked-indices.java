class Solution {
    boolean isPossibleToMarkKIndices(int [] nums, int k){

        int length = nums.length;
        for(int i=0;i<k;i++){
            if(2*nums[i]>nums[length-k+i])
                return false;
        }
        return true;
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        int left = 0 ;
        int right = length/2;
        int maxMarkedIndices = 0;
        while(left<=right){
            int mid = (left+right)/2;
            if(isPossibleToMarkKIndices(nums,mid)){
                left = mid+1;
                maxMarkedIndices = mid;
            }else{
                right = mid-1;
            }
        }
        return maxMarkedIndices*2;
    }
}

/*
    2,3,4,5
 */