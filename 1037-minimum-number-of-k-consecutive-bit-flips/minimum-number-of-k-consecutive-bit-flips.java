class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int length = nums.length;
        int count = 0;

        int noOfFlipsInCurrentWindow = 0;
        int problematicBit = 0;
        int pointer = 0;
        
        while(pointer<length){
            if(pointer-k>=0 && nums[pointer-k]==2)
                noOfFlipsInCurrentWindow--;
            problematicBit = (noOfFlipsInCurrentWindow%2==0)?0:1;

            if(nums[pointer]==problematicBit){
                if(pointer+k-1>=length)
                    return -1;
                count++;
                noOfFlipsInCurrentWindow++;
                nums[pointer] = 2;
            }


            pointer++;
        }

        return count;    
    }
}

