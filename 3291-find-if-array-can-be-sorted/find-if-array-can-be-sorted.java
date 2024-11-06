class Solution {
    boolean checkNoOfSetBits(int num1,int num2){
        int noOfSetBits1 = 0;
        int noOfSetBits2=0;
        for(int i=0;i<32;i++){
            if((num1&(1<<i))!=0)
               noOfSetBits1++;
            if((num2&(1<<i))!=0)
               noOfSetBits2++;
        }
        
        return noOfSetBits1==noOfSetBits2;
    }
    
    void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public boolean canSortArray(int[] nums) {
        
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-1;j++){
                if(nums[j+1]<nums[j]){
                    if(checkNoOfSetBits(nums[j+1],nums[j])){
                        swap(nums,j+1,j);
                    }
                }
            }
        }
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]<nums[i])
                return false;
        }
        
        return true;
        
        
    }
}