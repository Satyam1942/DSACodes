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
class Pair {
    int min, max;

    Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }

}

class Solution {
    int maxDif = 0;

    Pair traversal(TreeNode root) {
        if (root == null)
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);

        Pair left = traversal(root.left);

        int difMax = Math.abs(root.val - left.max);
        int difMin = Math.abs(root.val - left.min);
        if (left.max != Integer.MIN_VALUE)
            maxDif = Math.max(maxDif, difMax);
        if (left.min != Integer.MAX_VALUE)
            maxDif = Math.max(maxDif, difMin);

        Pair right = traversal(root.right);

        difMax = Math.abs(root.val - right.max);
        difMin = Math.abs(root.val - right.min);
        if (right.max != Integer.MIN_VALUE)
            maxDif = Math.max(maxDif, difMax);
        if (right.min != Integer.MAX_VALUE)
            maxDif = Math.max(maxDif, difMin);

        int nextMax = Math.max(left.max, Math.max(root.val, right.max));
        int nextMin = Math.min(left.min, Math.min(root.val, right.min));

        return new Pair(nextMin, nextMax);
    }
    public int maxAncestorDiff(TreeNode root) {
        traversal(root);
        return maxDif;
    }
}