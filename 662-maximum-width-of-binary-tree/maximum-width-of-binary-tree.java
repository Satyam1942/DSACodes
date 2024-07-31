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
class Pair{
    TreeNode node;
    int width;
    Pair(TreeNode node, int width){
        this.node = node;
        this.width = width;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int maxWidth = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int last = 0 ,first = 0;
            int startIndex = 0;
            for(int i=0;i<size;i++){
                TreeNode cur = q.peek().node;
                int width = q.peek().width;
                q.poll();

                if(i==0){
                    first = width;
                    startIndex = 2*width+1;
                }

                if(i==size-1){
                   last = width;
                }

                if(cur.left!=null)
                    q.add(new Pair(cur.left,2*width+1-startIndex));
                if(cur.right!=null)
                    q.add(new Pair(cur.right,2*width+2-startIndex));
            }
                maxWidth = Math.max(maxWidth,last-first+1); 
        }

        return maxWidth;
    }
}
/*
    0
    1           2
    2  3        4 5
 */