class Solution {
    public int[] singleNumber(int[] nums) {
        int length = nums.length;
        int x = 0, y=0;
        long xor = 0;
        for(int i=0;i<length;i++)
            xor^=nums[i];
      
        for(int i=32;i>=0;i--){
            if((xor&(1<<i))!=0){
                for(int j=0;j<length;j++){
                    if((nums[j]&(1<<i))!=0)
                        x^=nums[j];
                }

                for(int j=0;j<length;j++){
                     if((nums[j]&(1<<i))==0)
                        y^=nums[j];
                }
                break;
            }
        }

        int ans[] = new int[2];
        ans[0] = x;
        ans[1] = y;
        return ans;
    }
}

/*
        1 3 4

        110
        1   1
        2   

 */