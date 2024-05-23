class Solution {
    int generateSubset(int nums[] , int k , int index, HashSet<Integer> vis){
       if(index==nums.length){
        if(vis.size()>0)
            return 1;
        else
            return 0;
       }
       
       int notTake = generateSubset(nums,k,index+1,vis);
       int take = 0;

       if(!vis.contains(nums[index])){
            vis.add(nums[index]+k);
            take += generateSubset(nums,k,index+1,vis);
            vis.remove(nums[index]+k);
       }

        return take+notTake;
    }

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        return generateSubset(nums,k,0,set);
    }
}