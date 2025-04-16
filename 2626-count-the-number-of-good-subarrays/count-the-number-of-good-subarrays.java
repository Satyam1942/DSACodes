class Solution {
    public long countGood(int[] nums, int k) {
        int j=0;
        int i=0;
        long ans=0l;
        long count=0l;
        HashMap<Integer,Integer> hm=new HashMap<>();
        while(j<nums.length){
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            count += hm.get(nums[j]) - 1;
            while(count>=k){
                ans += (nums.length - j);
                int lf = hm.get(nums[i]);
                count-=lf-1;
                hm.put(nums[i], hm.get(nums[i]) - 1);
                if(hm.get(nums[i])==0)
                    hm.remove(nums[i]);              
                i++;
            }
            j++;
        }
        return ans;
    }
}