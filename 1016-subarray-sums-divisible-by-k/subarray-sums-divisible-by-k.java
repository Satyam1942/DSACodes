class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int length = nums.length;
        int sum = 0;
        int noOfSubarrays = 0;
        for(int i=0;i<length;i++){
            sum+=nums[i];
            int remainder = sum%k;
            if(remainder<0)
                remainder+=k;
            if(map.containsKey(remainder)){
                int freq = map.get(remainder);
                noOfSubarrays+=freq;
                map.put(remainder,freq+1);
            }else{
                map.put(remainder,1);
            }
        }

        return noOfSubarrays;
    }
}
/*
    map:
    0-2
    2-1
    4-4
    
    count  = 1+2+3+1
 */