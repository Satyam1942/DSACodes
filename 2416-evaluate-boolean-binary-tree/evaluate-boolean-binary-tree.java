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
class Solution {
    int postOrderTraversal(TreeNode root){
        if(root.left==null && root.right==null)
            return root.val;

        int left = postOrderTraversal(root.left);
        int right = postOrderTraversal(root.right);
     
        if(root.val==2)
            return left|right;
        else 
            return left&right;
    }

    public boolean evaluateTree(TreeNode root) {
        int val = postOrderTraversal(root);
        return val==1;

    }
}