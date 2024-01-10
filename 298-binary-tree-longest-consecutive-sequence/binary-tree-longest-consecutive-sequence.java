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
    TreeNode node;
    int maxSeqLength;

    Pair(TreeNode node, int maxSeqLength) {
        this.node = node;
        this.maxSeqLength = maxSeqLength;
    }
}

class Solution {
    int maxLength = 0;

    Pair getLongestConsecutiveLength(TreeNode node) {
        if (node == null)
            return new Pair(null, 0);

        Pair left = getLongestConsecutiveLength(node.left);
        Pair right = getLongestConsecutiveLength(node.right);

        int leftCount = 1, rightCount = 1;

        if (left.node != null && left.node.val - node.val == 1)
            leftCount += left.maxSeqLength;
        if (right.node != null && right.node.val - node.val == 1)
            rightCount += right.maxSeqLength;

        int length = Math.max(leftCount, rightCount);
        maxLength = Math.max(maxLength, length);
        return new Pair(node, length);

    }

    public int longestConsecutive(TreeNode root) {
        getLongestConsecutiveLength(root);
	    return maxLength;

    }
}