class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
         int n = nums.length;
        int length = Integer.MAX_VALUE;
        
        int prefixMatrix[][] = new int[n][32];
        for(int i=31;i>=0;i--){
            int sum =0;
            for(int j=0;j<n;j++){
                if((nums[j]&(1<<i))>0){
                    sum++;
                }
                prefixMatrix[j][i]= sum;
            }
        }
        // for(int row[]:prefixMatrix)
        //     System.out.println(Arrays.toString(row));
        
        int minLength = Integer.MAX_VALUE;
        for(int l=0;l<n;l++){
            int left = l;
            int right = n-1;
            int maxIndex = -1;
            
            while(left<=right){
                int mid = (left+right)/2;
                int newNum = 0;
                for(int i=31;i>=0;i--){
                    int key = (l==0)?0:prefixMatrix[l-1][i];
                    int res = (prefixMatrix[mid][i]-key==0)?0:1;
                    if(res==1)
                        newNum|=(1<<i);
                }
                if(newNum>=k){
                   right = mid-1;
                    maxIndex = mid;
                }else
                    left = mid+1;
            }
            // System.out.println(maxIndex);
            if(maxIndex!=-1)
                minLength = Math.min(minLength,maxIndex-l+1);
        }
        
        if(minLength==Integer.MAX_VALUE)
            return -1;
        return minLength;
        
    }
}