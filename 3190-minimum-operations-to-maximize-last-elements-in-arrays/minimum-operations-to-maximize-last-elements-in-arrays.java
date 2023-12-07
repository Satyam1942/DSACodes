class Solution {
    long rec(int index ,int nums1[], int nums2[],int n, Long dp[])
    {
            if(index == n-1) return dp[index]= 0l;
            if(dp[index]!=null) return dp[index];
           if(nums1[index]<=nums1[n-1] && nums2[index]<=nums2[n-1])
           return dp[index]=rec(index+1,nums1,nums2,n,dp);

            if(nums1[index]>=nums1[n-1])
            {
                if(nums1[index]<=nums2[n-1] && nums2[index]<=nums1[n-1])
                return  dp[index]= 1+rec(index+1,nums1,nums2,n,dp);
           
            }
            else if(nums2[index]>=nums2[n-1])
            {
              if(nums2[index]<=nums1[n-1] && nums1[index]<=nums2[n-1])
              return dp[index]= 1+rec(index+1,nums1,nums2,n,dp);
                  
            }
            
            return dp[index]= (long)Integer.MAX_VALUE;

    }
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Long dp1[] = new Long[n];
        Long dp2[] = new Long[n];
        //assume no swap of last elements
        long temp1 = rec(0,nums1,nums2,n,dp1);

        //assume swap of last elements
        int t = nums1[n-1];
        nums1[n-1] = nums2[n-1];
        nums2[n-1] = t;

        long temp2 = 1+rec(0,nums1,nums2,n,dp2);

        long minOpr = Math.min(temp1,temp2);
        if(minOpr>=Integer.MAX_VALUE) return -1;
        else return (int)minOpr;
    }
}