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

    void traversal(TreeNode root, int maxi, int mini) {
        if (root == null)
            return;

        int difMax = Math.abs(root.val - maxi);
        int difMin = Math.abs(root.val - mini);

        maxDif = Math.max(maxDif, Math.max(difMax, difMin));

        int newMaxi = Math.max(root.val, maxi);
        int newMini = Math.min(root.val, mini);
        traversal(root.left, newMaxi, newMini);
        traversal(root.right, newMaxi, newMini);

    }

    public int maxAncestorDiff(TreeNode root) {
        traversal(root,root.val,root.val);
        return maxDif;
    }
}