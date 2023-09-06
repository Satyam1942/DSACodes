class Solution {
    public int getMaxLen(int[] nums) {
        int maxi =0, positiveLength =0, negativeLength=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                positiveLength =0;
                negativeLength =0;
            }
            else if(nums[i]>0)
            {
                positiveLength++;
                negativeLength = (negativeLength ==0)? 0: negativeLength +1;
            }
            else
            {
                //swap
                int temp = negativeLength;
                negativeLength = positiveLength;
                positiveLength = temp;

                negativeLength++;
                if(temp!=0) positiveLength++;
            }
            
            maxi = Math.max(maxi,positiveLength);
        }

        return maxi;
    }
}