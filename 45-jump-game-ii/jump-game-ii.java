class Solution {
    public int jump(int[] nums) {
        int noOfJumps = 0;
        int length = nums.length;
        int pointer = 0;

        if(length==1)
            return 0;

        while(pointer<length){
            int newMaxIndex = pointer + nums[pointer];
            if(newMaxIndex>=length-1)
                break;
            int maxReachable = pointer + nums[pointer];
            int j = pointer+1;
            while(j<=maxReachable){
                if(newMaxIndex<j+nums[j]){
                    newMaxIndex = j+nums[j];
                    pointer = j;
                }
                j++;
            }
            noOfJumps++; 
        }

        return noOfJumps+1;
    }
}

/*
    int maxIndex = 2;
    int noOfJumps = 1
    2,1,2,1,4
 */