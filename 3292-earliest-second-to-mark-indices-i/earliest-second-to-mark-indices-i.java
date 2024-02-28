class Solution {
    boolean isPossible(int[] nums, int[] changedIndices, long maxTime){
        int lastIndex[] = new int[nums.length];
        int marked = 0;
        Arrays.fill(lastIndex,-1);

        for(int i=0;i<maxTime;i++)
            lastIndex[changedIndices[i]-1] = i;

        int availableIndices = 0;
        for(int i=0;i<maxTime;i++){
            if(lastIndex[changedIndices[i]-1] ==i){
                if(availableIndices>=nums[changedIndices[i]-1]){
                    marked++;
                    availableIndices-=nums[changedIndices[i]-1];
                }
            }else
                availableIndices++;
        }

        return marked==nums.length;
    }

    public int earliestSecondToMarkIndices(int[] nums, int[] changedIndices) {
        long sum = 0;
        int length = nums.length;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];

         long left =sum+(long)length;
         long right = changedIndices.length;
         long earliestSecond = 0l;

         while(left<=right){
             long mid = (left+right)/2;
             if(isPossible(nums,changedIndices,mid)){
                 earliestSecond = mid;
                 right = mid-1;
             }
             else 
                left = mid+1;
         }

        if(earliestSecond==0)
            return -1;

        return (int)earliestSecond;
    }
}