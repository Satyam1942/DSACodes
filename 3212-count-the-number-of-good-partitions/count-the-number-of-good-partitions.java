class Solution {
    boolean isPossible(int noOfPartitions, int []nums, HashMap<Integer,Integer> map)
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

        return (count-1)>=noOfPartitions;
    }

    public int numberOfGoodPartitions(int[] nums) {
        
        int left = 0;
        int right = nums.length-1;
        int maxPartitionAllowed = 0;
        HashMap<Integer,Integer> lastIndex =new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            lastIndex.put(nums[i],i);
        }

        while(left<=right)
        {
            int mid= (left+right)/2;
            if(isPossible(mid,nums,lastIndex)){left = mid+1; maxPartitionAllowed=mid;}
            else right= mid-1;
        }
        
        long ans = 1l;
        long mod= (long)(1e9+7);
        for(int i=0;i<maxPartitionAllowed;i++)
        {
            ans= (ans*2)%mod;
        }
        return (int)(ans);
    }
}