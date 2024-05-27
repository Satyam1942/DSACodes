class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for(int i=length-1;i>0;i--){
            int curNum = (length-i);
            if(nums[i]==curNum && nums[i-1]!=curNum)
                return curNum;
            if(nums[i]>curNum && nums[i-1]<curNum)
                return curNum;
        }

        int curNum = (length);
        if(nums[0]>=length)
            return length;
        return -1;
    }
}

/*
    0 2 2 3
 */