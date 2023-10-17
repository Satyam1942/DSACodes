class Solution {

    void preOrderTraversal(int node, int vis[] , int leftChild[], int rightChild[])
    {
        if(node==-1) return;
        vis[node]= 1;
        preOrderTraversal(leftChild[node],vis,leftChild,rightChild);
        preOrderTraversal(rightChild[node],vis,leftChild,rightChild);
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
      
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        
        for(int i=0;i<n;i++)
        {
            int lChild = leftChild[i];
            int rChild = rightChild[i];
            if(lChild!=-1)
            {
            indegree[lChild]++;
            outdegree[i]++;
            }
            if(rChild!=-1)
            {
                indegree[rChild]++;
                outdegree[i]++;
            }
        }

        boolean  flag = false;
        int rootNode =0;
        for(int i=0;i<n;i++)
        {
            if(outdegree[i]<0 || outdegree[i]>2) return false;
            if(indegree[i]==0)
            {
                if(!flag){  flag = true; rootNode = i;}
                else return false;
            } 
            else if(indegree[i]>1) return false;
        }

        if(!flag) return false;

        int vis[] = new int[n];
        preOrderTraversal(rootNode,vis,rightChild,leftChild);
        for(int i=0;i<n;i++) if(vis[i]==0) return false;

        return true;
    }
}