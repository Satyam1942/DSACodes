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
    int totalCoins = 0;
    int postOrderTraversal(TreeNode root){
        if(root==null)
            return 0;
        int leftCoins = postOrderTraversal(root.left);
        int rightCoins = postOrderTraversal(root.right);
        int curCoinsRequired = 1-root.val;
        totalCoins+= Math.abs(curCoinsRequired+leftCoins+rightCoins);
        return curCoinsRequired+leftCoins+rightCoins;
    }

    public int distributeCoins(TreeNode root) {
        postOrderTraversal(root);
        return totalCoins;
    }
}