class Solution {
    void addToFloorValue(int element, List<Integer> lis)
    {
        int left = 0;
        int right = lis.size()-1;
        int index = right;
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(element<=lis.get(mid)){index = mid;  right = mid-1;}
            else left = mid+1;
        }

        lis.set(index,element);
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);
        for(int i=1;i<nums.length;i++)
        {
            int lastVal = lis.get(lis.size()-1);
            if(nums[i]>lastVal) lis.add(nums[i]);
            else addToFloorValue(nums[i],lis);
        }

        return lis.size();
    }
}