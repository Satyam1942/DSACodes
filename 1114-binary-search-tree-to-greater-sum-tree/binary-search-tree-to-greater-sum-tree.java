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
    int convertTree(TreeNode root,int sum){
        if(root==null){
            return sum;
        }

        int rightSum = convertTree(root.right,sum);
        root.val+=rightSum;
        int leftSum =  convertTree(root.left,root.val);
    
         return leftSum;
    }
    public TreeNode bstToGst(TreeNode root) {
        convertTree(root,0);
        return root;
    }
}