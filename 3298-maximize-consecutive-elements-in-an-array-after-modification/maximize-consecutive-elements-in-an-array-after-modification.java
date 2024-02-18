class Solution {
    public int maxSelectedElements(int[] nums) {
        HashMap<Integer,Integer> dp = new HashMap<>();
        Arrays.sort(nums);
        int length = nums.length;
        int maxi = 0;
        for(int i=0;i<length;i++){
            dp.put(nums[i]+1,dp.getOrDefault(nums[i],0)+1);
            dp.put(nums[i],dp.getOrDefault(nums[i]-1,0)+1);
            maxi = Math.max(maxi,Math.max(dp.get(nums[i]),dp.get(nums[i]+1)));
        }
        System.out.println(dp);
        return maxi;
    }
}