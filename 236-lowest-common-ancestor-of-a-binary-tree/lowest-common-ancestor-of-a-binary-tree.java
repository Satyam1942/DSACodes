/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

        TreeNode traversal(TreeNode root , TreeNode p, TreeNode q)
        {
            if(root==null || root==p || root==q) return root;

            TreeNode left = traversal(root.left,p,q);
            TreeNode right = traversal(root.right,p,q);

            if(left!=null && right!=null) return root;
            
            if(left!=null) return left;
            else return right;

        }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            return traversal(root,p,q);
    }
}