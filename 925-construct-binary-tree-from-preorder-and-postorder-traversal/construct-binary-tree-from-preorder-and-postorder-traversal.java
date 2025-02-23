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
    int preOrderIndex = 0;
    int postOrderIndex = 0;

    TreeNode buildTree(int[] preorder, int [] postorder) {
        if(preOrderIndex >= preorder.length) {
            return null;
        }

        int curNode = preorder[preOrderIndex];
        TreeNode newNode = new TreeNode(curNode);
        if(curNode != postorder[postOrderIndex]) {
            preOrderIndex++;
            newNode.left = buildTree(preorder, postorder);
        }
        if(curNode != postorder[postOrderIndex]) {
            preOrderIndex++;
            newNode.right = buildTree(preorder, postorder);
        } 
        postOrderIndex++;
        return newNode; 
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildTree(preorder, postorder);
    }
}