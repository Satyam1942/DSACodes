class Solution {
    int getCeilingCount(int x, int nums[]){
        int length = nums.length;
        int left = 0;
        int right = length-1;
        int numberOfElements = 0;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]>=x){
                numberOfElements = length-mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return numberOfElements;
    }
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for(int i=0;i<=nums[length-1];i++){
            int numberOfElementsGreaterThanEqualToX = getCeilingCount(i,nums);
            if(numberOfElementsGreaterThanEqualToX==i)
                return i;
        }
        return -1;
    }
}