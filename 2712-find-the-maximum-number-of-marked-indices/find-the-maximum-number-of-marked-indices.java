class Solution {
    boolean isPossibleToMatchK(int nums[] , int k){
        int length = nums.length;

        for(int i=0;i<k;i++){
            if(2*nums[i]>nums[length-(k-i)])
                return false;
        }
        return true;
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length/2;
        int k = 0;
        while(left<=right){
            int mid  = (left+right)/2;
            if(isPossibleToMatchK(nums,mid)){
                k = mid;
                left  = mid+1;
            }else
                right = mid-1;
        }

        return 2*k;
    }
}