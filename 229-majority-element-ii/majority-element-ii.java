class Solution {
    public List<Integer> majorityElement(int[] nums) {
Map<Integer,Integer> map = new HashMap<>();
List<Integer> ans = new ArrayList<>();
for(int i=0;i<nums.length;i++)
{
  int value = map.getOrDefault(nums[i],0);
 map.put(nums[i],value+1); 
}
for(Map.Entry<Integer,Integer> it: map.entrySet())
{
   if(it.getValue()>(nums.length/3))ans.add(it.getKey());
}


return ans;
 
    }
}