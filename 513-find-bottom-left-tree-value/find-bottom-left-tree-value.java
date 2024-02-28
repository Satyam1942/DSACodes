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
    public int findBottomLeftValue(TreeNode root) {
        TreeNode tempNode = root;

        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(tempNode);

        while (!q.isEmpty()) {
            int size = q.size();
            int leftmostNode = 0;
            boolean flag = false;
            boolean isFirstIteration = true;

            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                    flag = true;
                }
                if (node.right != null) {
                    q.add(node.right);
                    flag = true;
                }
                if (isFirstIteration) {
                    leftmostNode = node.val;
                    isFirstIteration = false;
                }
            }

            if (!flag)
                return leftmostNode;

        }

        return -1;

    }
}