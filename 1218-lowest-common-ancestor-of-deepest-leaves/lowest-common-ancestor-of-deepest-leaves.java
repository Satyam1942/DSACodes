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

class LevelNode {
    TreeNode node; 
    int depth;
    LevelNode(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class Solution {
    LevelNode dfs(TreeNode root, int level) {
        if(root == null) {
            return new LevelNode(null, level);
        }

        LevelNode left = dfs(root.left, level+1);
        LevelNode right = dfs(root.right, level+1);
        left.node = (left.node==null)? root : left.node;
        right.node = (right.node==null)? root : right.node;

        if(left.depth == right.depth) {
            return new LevelNode(root, left.depth);
        } else if(left.depth>right.depth) {
            return left;
        } else {
            return right;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        LevelNode lca = dfs(root, 0);
        return lca.node;
    }
}