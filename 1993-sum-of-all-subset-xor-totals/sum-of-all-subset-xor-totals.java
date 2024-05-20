class Solution {
    public int subsetXORSum(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for(int i=0;i<(1<<length);i++){
            int xor = 0;
            for(int j=0;j<length;j++){
                if((i&(1<<j))>0){
                    xor^=nums[j];
                }
            }
            sum+=xor;
        }
        return sum;
    }
}
/*
    [2,3,12,4,13,3,21]
 */
