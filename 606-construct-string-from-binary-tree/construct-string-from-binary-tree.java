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
    String preOrderTraversal(TreeNode root)
    {
        if(root==null) return "";
         String h = String.valueOf(root.val);
        if(root.left==null && root.right==null)  return h;
         String left  = "(" + preOrderTraversal(root.left)+")";
         if(root.right==null) return h+left;
         String right =  "("+preOrderTraversal(root.right)+")";

        return h+left+right;

    }
    public String tree2str(TreeNode root) {
        return preOrderTraversal(root);

    }
}