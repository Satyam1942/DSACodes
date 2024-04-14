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
    int depthFirstSearch(TreeNode root,TreeNode parent){
        if(root==null)
            return 0;
        int sum = 0;
        sum += depthFirstSearch(root.left,root);
        sum += depthFirstSearch(root.right,root);

        if(root.left==null && root.right==null && parent!=null && parent.left ==root)
            sum+=root.val;

        return sum;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return depthFirstSearch(root,null);
    }
}