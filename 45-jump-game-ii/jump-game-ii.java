class Solution {
    public int jump(int[] nums) {
        
        /*
        [2,3,1,1,4]
        i = 0 , val =2 , check for 3,1 
        */ 

        int length = nums.length;
        int noOfJumps =0;
        int maximumThatICanJump = 0;

        if(length==1) return 0;

        for(int index = 0;index<length;)
        {
            
            maximumThatICanJump = nums[index];
            int maximumIndexReach = index+maximumThatICanJump;
            if(maximumIndexReach>=length-1) break;

            int maxNextJumpValue=maximumIndexReach;
            
            for(int forward = index+1; forward<=maximumIndexReach;forward++)
            {
            if(nums[forward]+forward>maxNextJumpValue)
            {
                index = forward;
                maxNextJumpValue =  nums[forward]+forward ;
            }
            }


            noOfJumps++;
        }

        return noOfJumps+1;

    }
}