class Solution {
    public int[][] divideArray(int[] nums, int k) {
        /*
        1,1,3,3,4,5,7,8,9
        1,2,3,3,3,7
        */
        
        Arrays.sort(nums);
        int length = nums.length;
        int mat[][] =new int[length/3][3];
        
        int upperIndex = 2;
        int lowerIndex = 0;
        int pointer =0;
       while(upperIndex<length)
       {
            if(nums[upperIndex]-nums[lowerIndex]<=k)
            {
                int temp[] = new int[3];
                for(int j=lowerIndex;j<=upperIndex;j++)
                {
                    temp[j-lowerIndex] = nums[j];
                }
                mat[pointer]=temp;
                pointer++;
                lowerIndex = upperIndex+1;
                upperIndex = lowerIndex+2;
            }
            else return  new int[0][0];
        }
        
        return mat;
    }
}