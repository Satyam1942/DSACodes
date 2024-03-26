class Solution {
    void initialiseNegativeNumbersAsZero(int nums[]){
        int len = nums.length;
        for(int i=0;i<len;i++) {
            if(nums[i]<0)
                nums[i]=0;
        }
    }

    int getFirstNonNegativeNumber(int nums[]){
         int len = nums.length;

         for(int i=1;i<=len;i++) {
            if(nums[i-1]>=0) 
                return i;
         }
        return len+1;
    }

    public int firstMissingPositive(int[] nums) {

         int len = nums.length;

        initialiseNegativeNumbersAsZero(nums);

         for(int i=0;i<len;i++) {
             int index = Math.abs(nums[i])-1;
             if(index>=0 && index<len && nums[index]>=0)
             {
                if(nums[index]==0) 
                    nums[index]= -(len+1);
                else  
                    nums[index]= -nums[index];
             }
         }


        int firstMissingPositive = getFirstNonNegativeNumber(nums);

        return firstMissingPositive;
    }
}