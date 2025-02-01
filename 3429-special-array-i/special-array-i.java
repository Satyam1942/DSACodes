class Solution {
    public boolean isArraySpecial(int[] nums) {
        int length = nums.length;
        
        boolean isEven = nums[0]%2==0;
       
        for(int i=1;i<length;i++){
            if(isEven){
                if(nums[i]%2==0)
                    return false;
                else
                    isEven=!isEven;
            }else{
                if(nums[i]%2!=0)
                    return false;
                else
                    isEven=!isEven;
            }
        }
        
        return true;
    }
}