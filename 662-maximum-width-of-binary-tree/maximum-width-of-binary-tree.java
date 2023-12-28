/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair
{
    int nodeNum ;
    TreeNode node;
    Pair(TreeNode node, int nodeNum)
    {
        this.node= node;
        this.nodeNum = nodeNum;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root==null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,1));

        int maxmWidth = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            int first = 0 ,last = 0;
            for(int i =0;i<size;i++)
            {
                TreeNode cur = q.peek().node;
                int nodeNum = q.peek().nodeNum;
                q.poll();

                if(i==0) first = nodeNum;
                if(i==size-1) last = nodeNum;
                
                if(cur.left!=null)q.add(new Pair(cur.left,2*nodeNum-first));
                if(cur.right!=null)q.add(new Pair(cur.right,2*nodeNum-first+1));
            }
            maxmWidth = Math.max(maxmWidth,last-first+1);
        }

        return maxmWidth;
    }
}