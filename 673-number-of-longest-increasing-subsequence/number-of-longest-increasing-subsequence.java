class Solution {
    public int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        int cache[][] = new int[length][2];
       for(int i=0;i<length;i++){
            cache[i][0] = 1;
            cache[i][1] = 1;
       }

        for (int prev = 0; prev < length; prev++) {
            for (int cur = prev+1; cur < length; cur++) {
                if (nums[cur] > nums[prev]) {
                    if(cache[cur][0]<cache[prev][0]+1){
                        cache[cur][0] = cache[prev][0]+1;
                        cache[cur][1] = cache[prev][1];
                    }else if(cache[cur][0]==cache[prev][0]+1){
                        cache[cur][1]+= cache[prev][1];
                    }
                }
            }
        }

        int lisLength = 0;
        for(int i=0;i<length;i++){
            lisLength = Math.max(cache[i][0],lisLength);
        }
    
        int count = 0;
        for(int i=0;i<length;i++){
            if(lisLength==cache[i][0])
                count+=cache[i][1];
        }

        return count;
    }
}

/*
 * 1,3,5,4,7
   1 2 3 3 4
   1 1 1 1 2 

   1 2 4 3 5 4 7 2
   1 2 3 3 4 4 5 2
   1 1 1 1 2 1 3 1

 */