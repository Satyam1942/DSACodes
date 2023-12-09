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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> inOrder = new ArrayList<>();

        if(root ==null) return inOrder;

        while(true)
        {
             if(root!=null)
             {
                 stack.push(root);
                 root = root.left;
             }
             else{
                 if(stack.isEmpty()) break;
                 root = stack.pop();
                 inOrder.add(root.val);
                 root =root.right;
                }
        }


        return inOrder;
        
    }
}