class Solution {
    public List<Integer> majorityElement(int[] nums) {

         List<Integer> majorityElement = new ArrayList<>();

        int majorityElement1= Integer.MAX_VALUE ,majorityElement2=Integer.MIN_VALUE;
        int count1 =0 ,count2 =0,right =0;
        while(right<nums.length)
        {
            if(nums[right]==majorityElement1) count1++;
            else if(nums[right]==majorityElement2)count2++;
            else if(count1==0)
            {
                majorityElement1 = nums[right];
                count1=1;
            }
            else if(count2==0)
            {
                majorityElement2 = nums[right];
                count2=1;
            }
            else
            {   
                count1--;
                count2--;
            }   
            right++;
        }

       
        count1=0;count2=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==majorityElement1)count1++;
            if(nums[i]==majorityElement2)count2++;
            
        }

        if(count1>nums.length/3) majorityElement.add(majorityElement1);
        if(count2>nums.length/3) majorityElement.add(majorityElement2);
        
        return majorityElement;
    }
}