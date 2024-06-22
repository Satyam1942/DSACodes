class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = 0;
        int oddCount = 0;
        int subArrayCount = 0;
        int firstOddPosition = 0;

        Queue<Integer> q = new LinkedList<>();
        while(left<=right && right<=length){
            if(oddCount>k){
                if(nums[left]%2!=0){
                    oddCount--;
                    q.poll();
                }
                left++;
                continue;
            }

            if(oddCount==k){
                subArrayCount += q.peek()-left+1;
            }
        
            if(right<length && nums[right]%2!=0){
                q.add(right);
                oddCount++;
            }
           
            right++;
        }

        return subArrayCount;
    }
}

/*
    l = 0
*/