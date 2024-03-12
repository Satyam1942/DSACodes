class Solution {
    public long minimumReplacement(int[] nums) {
        long noOfMoves = 0;
        int length = nums.length;
        int minNumber = nums[length-1];

        for(int i=length-2;i>=0;i--){
            if(minNumber<nums[i]){
                int tempCost = (nums[i]/minNumber);
                if(nums[i]%minNumber!=0){
                   tempCost++;
                    minNumber= nums[i]/tempCost;
                }
                noOfMoves+= (tempCost-1);
            }else{
                minNumber = nums[i];
            }
        }

        return noOfMoves;
    }
}