class Solution {
    boolean isPossible(int dif, int nums[], int k){
        int length = nums.length;
        int rank = 0;

        for(int i=0;i<length;i++) {
            int j=i;
            while(j<length && nums[j]-nums[i]<=dif)
                j++;
            rank+=j-i-1;
        }

        return rank>=k;
    }
    
    int getMinDif(int nums[]){
        int length = nums.length;
        int minDif = Integer.MAX_VALUE;
        for(int i=0;i<length-1;i++){
            minDif = Math.min(minDif,nums[i+1]-nums[i]);
        }
        return minDif;
    }

    int getMaxDif(int nums[]){
        int length = nums.length;
        return nums[length-1]-nums[0];
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int left = getMinDif(nums);
        int right =  getMaxDif(nums);
        int kthSmallestDistance = right;

        while(left<=right){
            int mid = (left+right)/2;
            if(isPossible(mid,nums,k)){
                right = mid-1;
                kthSmallestDistance = mid;
            }else
                left = mid+1;
        }

        return kthSmallestDistance;


    }
}