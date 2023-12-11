class Solution {
    int getMaxPartition(int []nums, HashMap<Integer,Integer> map)
    {
        int count = 0;
        int maxPIndex= 0;
        for(int i=0;i<nums.length;i++)
        {
            if(map.get(nums[i])!=i) 
            {
                maxPIndex = Math.max(maxPIndex,map.get(nums[i]));
            }
            if(i>=maxPIndex)count++;
        } 

        return (count-1);
    }

    public int numberOfGoodPartitions(int[] nums) {
        
        int left = 0;
        int right = nums.length-1;

        HashMap<Integer,Integer> lastIndex =new HashMap<>();
        
        for(int i=0;i<nums.length;i++) lastIndex.put(nums[i],i);

        int maxPartitionAllowed = getMaxPartition(nums,lastIndex);
        
        long ans = 1l;
        long mod= (long)(1e9+7);
        for(int i=0;i<maxPartitionAllowed;i++) ans= (ans*2)%mod;
        
        return (int)(ans);
    }
}