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
    public int  rec(TreeNode root, int []maxi)
    {
            if(root==null) return 0;
            int lPathSum = Math.max(rec(root.left,maxi),0);
            int rPathSum = Math.max(rec(root.right,maxi),0);
            maxi[0] = Math.max(maxi[0], lPathSum+rPathSum+root.val);

            return root.val+Math.max(lPathSum , rPathSum);
    }

    public int maxPathSum(TreeNode root) {
        int maxi[]= new int[1];
        maxi[0]= Integer.MIN_VALUE;
        rec(root,maxi);

        return maxi[0];
    }
}