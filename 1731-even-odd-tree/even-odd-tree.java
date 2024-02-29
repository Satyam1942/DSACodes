/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean isEven = true;
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            int prevNodeVal = (isEven) ? 0 : Integer.MAX_VALUE;
            while (size-- > 0) {
                TreeNode curNode = q.poll();
                if (curNode.left != null)
                    q.add(curNode.left);
                if (curNode.right != null)
                    q.add(curNode.right);
                if (isEven) {
                    if (curNode.val % 2 != 0 && curNode.val > prevNodeVal)
                        prevNodeVal = curNode.val;
                    else
                        return false;
                } else {
                    if (curNode.val % 2 == 0 && curNode.val < prevNodeVal)
                        prevNodeVal = curNode.val;
                    else
                        return false;
                }
            }
            isEven = !isEven;
        }

        return true;

    }
}