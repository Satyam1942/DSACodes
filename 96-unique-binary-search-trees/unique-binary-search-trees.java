class Solution {

    int rec(int inOrder[] , int left ,int right,int dp[][] )
    {
        if(right<=left) return 1;
       if(dp[left][right]!=-1) return dp[left][right];

        int total=0;
        for(int i=left;i<=right;i++)
        {
            total+= rec(inOrder,left,i-1,dp)*rec(inOrder,i+1,right,dp);
        }
        return dp[left][right] = total;
    }
    public int numTrees(int n) {
        int inorder[] = new int[n];
        int dp[][] = new int[n][n];
        for(int row[] : dp) Arrays.fill(row,-1);

        for(int i=0;i<n;i++)inorder[i]=i+1;
        return rec(inorder,0,n-1,dp);

    }
}