class Solution {
    public int minIncrementForUnique(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        HashSet<Integer> vis = new HashSet<>();
        vis.add(nums[0]);
        int prevElement = nums[0];
        int count = 0;
        for (int i = 1; i < length; i++) {
            if (vis.contains(nums[i])){
                int newNum = prevElement + 1;
                count += newNum - nums[i];
                vis.add(newNum);
                prevElement = newNum;
            }else{
                vis.add(nums[i]);
                prevElement = nums[i];
            }
        }
        return count;

    }
}
/*
    1,1,2,2,3,7
      
 */