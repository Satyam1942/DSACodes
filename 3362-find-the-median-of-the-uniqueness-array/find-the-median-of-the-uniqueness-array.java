class Solution {
    boolean isPossible(int element, int nums[]){
        int length = nums.length;
        long totalElements = ((long)length*((long)length+1l))/2;
        long medianPos = (totalElements%2!=0)? (totalElements+1)/2 : totalElements/2;

        long lessElementsCount = 0;
        int i=0,j=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(i<=j && j<=length){
            if(map.size()>element){
                int freq= map.get(nums[i]);
                if(freq==1)
                    map.remove(nums[i]);
                else 
                    map.put(nums[i],freq-1);
                i++;
                continue;
            }

            if(j<length){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);    
            }
            lessElementsCount+=(long)(j-i);
            j++;
        }
        return lessElementsCount>=medianPos;
    }

    public int medianOfUniquenessArray(int[] nums) {
        int length = nums.length;
        int left = 1;
        int right = length;

        int median = length;
        while(left<=right){
            int mid = (left+right)/2;
            if(isPossible(mid,nums)){
                right = mid-1;
                median = mid;
            }else 
                left = mid+1;
        }

        return median;
    }
}