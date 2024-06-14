class Solution {
    int getScore(int left, int right, int nums[], Integer cache[][]){
        if(left>right)
            return 0;
        if(cache[left][right]!=null)
            return cache[left][right];

        int pickLeft = nums[left]-getScore(left+1,right,nums,cache);
        int pickRight = nums[right]-getScore(left,right-1,nums,cache);

        return cache[left][right] = Math.max(pickLeft,pickRight);
    }
    public boolean predictTheWinner(int[] nums) {
        int length  = nums.length;
        Integer cache[][] = new Integer[length][length];
        int score = getScore(0,length-1,nums,cache);
        return score>=0;
    }
}