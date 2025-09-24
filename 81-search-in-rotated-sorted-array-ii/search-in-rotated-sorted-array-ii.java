class Solution {
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = nums.length-1;

        while(left<=right) {
            int mid = (left+right)/2;
            if(target == nums[mid]) {
                return true;
            }

            if(target>nums[mid]) {
                if(nums[mid]>nums[left]) {
                    left = mid+1;
                } else if (nums[mid]==nums[left]) {
                    left++;
                } else {
                    if(target>nums[right]) {
                        right = mid-1;
                    } else {
                        left = mid+1;
                    }
                }
            } else {
                if(nums[mid]<nums[right]) {
                    right = mid-1;
                } else if (nums[mid]==nums[right]) {
                    right--;
                } else {
                    if(target>=nums[left]) {
                        right = mid-1;
                    } else {
                        left = mid+1;
                    }
                }
            }
        }

        return false;
    }
}

/*
    2, 5, 6, 0 0 1 2
    mid => number> mid and on the right side
           number > mid and on the left side
            number<mid  and on  right side 
            number<mid and on the left side

    number>mid and number>rightmost => left
    number>mid and number<rightmost => 
*/