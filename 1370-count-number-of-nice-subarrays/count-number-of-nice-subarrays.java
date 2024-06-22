class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = 0;
        
        int subArrayCount = 0;
        Queue<Integer> q = new LinkedList<>();
        
        while(left<=right && right<=length){
            if(q.size()>k){
                if(nums[left]%2!=0){
                    q.poll();
                }
                left++;
                continue;
            }

            if(q.size()==k){
                subArrayCount += q.peek()-left+1;
            }
        
            if(right<length && nums[right]%2!=0){
                q.add(right);
            }
           
            right++;
        }

        return subArrayCount;
    }
}

/*
    l = 0
*/