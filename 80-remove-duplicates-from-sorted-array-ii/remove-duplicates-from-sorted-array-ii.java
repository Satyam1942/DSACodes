class Solution {
    public int removeDuplicates(int[] nums) {
        
        int j=0,i=1;
        int prevCount = 1;
        
        while(i<nums.length)
        {
            if(nums[i]==nums[j]) 
            {
                prevCount++;
                if(prevCount>2) { i++; continue;}
            }
            else
            {
                prevCount = 1;
            }

            nums[++j]= nums[i];
            i++;
        }

        return j+1;
    }
}

/*
    0,0,1,1,2,3,2,3,3
          
 */ 