class Solution {
    boolean isPossible (int nums[], int capacity, int k) {
        int length = nums.length;
        int maxHouses = 0;
        for(int i=0; i<length;) {
            if(nums[i]>capacity) {
                i++;
            } else {
                maxHouses++;
                i+=2;
            }
        }

        return maxHouses>=k;
    }

    public int minCapability(int[] nums, int k) {
        int length = nums.length;
        int left =  Arrays.stream(nums).min().getAsInt();
        int right =  Arrays.stream(nums).max().getAsInt();
        int minCapacity = right;
        while(left<=right) {
            int mid = (left+right)/2;
            if(isPossible(nums, mid, k)) {
                minCapacity = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return minCapacity;
    }
}

/*
  Max in each path
  Min of all paths
  left = 2
  right = 9
  [2, 3, 9, 5]

*/