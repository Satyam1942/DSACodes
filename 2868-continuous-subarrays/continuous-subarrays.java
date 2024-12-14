class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long noOfSubarrays=0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        int right =0,left=0;
     
     
      while(left<n) {
            mini =Math.min(mini,nums[left]);
            maxi = Math.max(maxi,nums[left]);
            map.put(nums[left],map.getOrDefault(nums[left],0)+1);
            
             while(Math.abs(maxi-mini)>2) {
                map.put(nums[right], map.get(nums[right])-1);
                if(map.get(nums[right])==0) map.remove(nums[right]);
                mini =map.firstKey();
                maxi = map.lastKey();
               right++;
            }
              noOfSubarrays+=(left-right+1); 
            
             left++;
      }
        
        return noOfSubarrays;
    }
}