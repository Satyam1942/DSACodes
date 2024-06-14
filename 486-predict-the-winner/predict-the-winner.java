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
        int cache[][] = new int[length+1][length+1];

        for(int left = length-1;left>=0;left--){
            for(int right = 1;right<length;right++){
                if(left>right)
                    continue;

                int pickLeft = nums[left]-cache[left+1][right];
                int pickRight = nums[right]-cache[left][right-1];
                cache[left][right] = Math.max(pickLeft,pickRight);
            }
        }

        return cache[0][length-1]>=0;
    }
}