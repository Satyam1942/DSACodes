class Solution {
    int rec(int i , int j, int nums1[], int nums2[], Integer dp[][] )
    {
            if(i>=nums1.length && j==0) return Integer.MIN_VALUE;
            if(j>=nums2.length || i>=nums1.length) return 0;
            if(dp[i][j]!=null) return dp[i][j];
            int maxi = Integer.MIN_VALUE;
            int notTake = rec(i+1,j,nums1,nums2,dp);
            for(int k = j;k<nums2.length;k++)
            {
               int temp =  nums1[i]*nums2[k] + rec(i+1,k+1,nums1,nums2,dp);
               maxi = Math.max(maxi,temp);
            }
            maxi = Math.max(maxi,notTake);
            return dp[i][j] = maxi;
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        Integer dp[][] = new Integer[m][n];

        return rec(0,0,nums1,nums2,dp);
    }
}