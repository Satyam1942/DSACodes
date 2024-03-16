class Solution {
    public int findMaxLength(int[] nums) {
        int countZero = 0;
        int countOne = 0;
        int maxLength = 0;
        HashMap<Integer,Integer> difMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
           if(nums[i]==0)
                countZero++;
           else 
                countOne++;
            
            if(!difMap.containsKey(countOne-countZero))
                difMap.put(countOne-countZero,i);

            if(countOne==countZero)
                maxLength = countOne+countZero;
            else{
                if(difMap.containsKey(countOne-countZero)){
                    int prevIndex =  difMap.get(countOne-countZero);
                    maxLength = Math.max(maxLength,i-prevIndex);
                }
            }
        }

        return maxLength;

    }
}
/*

    01101110
    
    0-1
    1-2

    0-2
    1-3

    maxLength = 2
 */