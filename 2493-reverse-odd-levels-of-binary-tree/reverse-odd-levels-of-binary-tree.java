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
    public TreeNode reverseOddLevels(TreeNode root) {
        boolean isEvenLevel = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();

            while (size-- > 0) {
                TreeNode left = q.peek().left;
                TreeNode right = q.peek().right;
                q.poll();
                if (left != null && right != null && !isEvenLevel) {
                    arrayDeque.addFirst(left);
                    arrayDeque.addFirst(right);
                }
                if (left != null) {
                    q.add(left);
                }
                if (right != null) {
                    q.add(right);
                }
            }

            if (!isEvenLevel) {
                while (!arrayDeque.isEmpty()) {
                    TreeNode front = arrayDeque.removeFirst();
                    TreeNode last = arrayDeque.removeLast();
                    int temp = front.val;
                    front.val = last.val;
                    last.val = temp;
                }
            }
            isEvenLevel = !isEvenLevel;
        }

        return root;
    }
}

/*
 * 
 * 0
 * 1 2
 * 0 0 0 0
 * 1 1 1 1 2 2 2 2
 * 
 */