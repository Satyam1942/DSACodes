class Solution {
    public int minKBitFlips(int[] nums, int k) {
  
        int length = nums.length;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        int problematicBit = 0;
        int pointer = 0;
        
        while(pointer<length){
            if(nums[pointer]==problematicBit){
                count++;
                q.add(pointer+k-1);
            }
            
            if(!q.isEmpty() && q.peek()==pointer)
                q.poll();
            problematicBit = (q.size()%2==0)?0:1;
            pointer++;
        }

        if(!q.isEmpty())
            return -1;

        return count;
        
    }
}

/*
    for k=1 => no of zeroes
    for k=2 => 

    0,0,0,1,0,1,1,0
    1,1,1,1,1,1,1,1

    int count = 3;
    int windowSize = 2;
    flag = 1;
    Queue=>  7
    
 */