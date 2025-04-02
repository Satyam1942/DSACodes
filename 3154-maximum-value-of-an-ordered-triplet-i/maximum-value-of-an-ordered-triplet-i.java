class Solution {
    public long maximumTripletValue(int[] nums) {
        long product = Long.MIN_VALUE;
         for(int i = 0;i<nums.length-2;i++)
         {
             for(int j = i+1;j<nums.length-1;j++)
             {
                 for(int k = j+1;k<nums.length;k++)
                 {
                     product = Math.max(product,((long)nums[i]-(long)nums[j])*(long)nums[k]);
                 }
             }
         }
        
        if(product<0) return  0;
        return product;
        
    }
}