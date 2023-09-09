class Solution {
    int merge(int[] nums, int left, int mid, int right)
    {
        int low = left;
        int high = mid+1;
        int count=0;
        List<Integer> temp = new ArrayList<>();

        while(low<=mid && high<=right)
        {
            if((long)nums[low]>(long)2*(long)nums[high])
            {
                count+= mid-low+1;
                high++;
            }
            else low++;
        }

        low = left;
        high =mid+1;
        while(low<=mid && high<=right)
        {
            if(nums[low]<=nums[high])
            {
                temp.add(nums[low]);
                low++;
            }
            else 
            {
                temp.add(nums[high]);
                high++;
            }
        }

        while(low<=mid) {temp.add(nums[low]); low++;}
        while(high<=right) {temp.add(nums[high]); high++;}

        for(int i=left;i<=right;i++)
        {
            nums[i] =  temp.get(i-left);
        }
        return count;
    }

    void mergeSort(int [] nums, int left, int right ,int [] count)
    {
        if(left==right) return;
        int mid = (left+right)/2;
        mergeSort(nums,left,mid,count);
        mergeSort(nums,mid+1,right,count);
        count[0]+=merge(nums,left,mid,right);
    }
    public int reversePairs(int[] nums) {
        int [] count = new int[1];
     mergeSort(nums,0,nums.length-1,count);
     return count[0];
    }
}