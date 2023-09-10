class Solution {

    int rec(int inOrder[] , int left ,int right)
    {
        if(right<=left) return 1;
       

        int total=0;
        for(int i=left;i<=right;i++)
        {
            total+= rec(inOrder,left,i-1)*rec(inOrder,i+1,right);
        }
        return total;
    }
    public int numTrees(int n) {
        int inorder[] = new int[n];
        for(int i=0;i<n;i++)inorder[i]=i+1;
        return rec(inorder,0,n-1);

    }
}