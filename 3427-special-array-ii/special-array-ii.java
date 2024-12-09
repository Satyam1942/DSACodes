class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        boolean isEven = nums[0]%2==0;
       
        for(int i=1;i<nums.length;i++){
            if(isEven) {
                if(nums[i]%2==0)
                    map.put(i-1,i);
                else
                    isEven=!isEven;
            } else {
                if(nums[i]%2!=0) {
                     map.put(i-1,i);
                }
                else {
                    isEven=!isEven;
                }
            }
        }
        
        boolean ans[] = new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            Integer key = map.ceilingKey(l);
            if(key!=null && key<=r && key+1<=r){
                ans[i] = false;
            }else
                ans[i] =true;
        }
        return ans;
    }
}