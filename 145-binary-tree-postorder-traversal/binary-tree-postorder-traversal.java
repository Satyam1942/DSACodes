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
    void traversal(TreeNode root, List<Integer>postOrderList){
        if(root==null)
            return ;
        traversal(root.left,postOrderList);
        traversal(root.right,postOrderList);
        postOrderList.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrderList  = new ArrayList<>();
        traversal(root,postOrderList);
        return postOrderList;
    }
}