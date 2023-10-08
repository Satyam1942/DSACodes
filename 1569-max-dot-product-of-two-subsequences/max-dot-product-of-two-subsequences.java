class Solution {
    int rec(int i , int j,int check ,  int nums1[], int nums2[], Integer dp[][][] )
    {
            
            if(j>=nums2.length ||  i>=nums1.length)
            {
                if(check==0) return Integer.MIN_VALUE;
                else return 0;
            }
           

            if(dp[i][j][check]!=null) return dp[i][j][check];
            
            int notTake1 = rec(i+1,j,check,nums1,nums2,dp);
            int notTake2 = rec(i,j+1,check,nums1,nums2,dp);            
            int take =  nums1[i]*nums2[j] + rec(i+1,j+1,1, nums1,nums2,dp);

            return dp[i][j][check] = Math.max(take,Math.max(notTake1,notTake2));
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        Integer dp[][][] = new Integer[m][n][2];

        return rec(0,0,0,nums1,nums2,dp);
    }
}