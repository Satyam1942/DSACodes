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
    void traversal(TreeNode root, List<Integer> leafSimilar)
    {
        if(root==null) return;
        traversal(root.left,leafSimilar);
        if(root.left==null && root.right==null) leafSimilar.add(root.val);
        traversal(root.right,leafSimilar);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSequence1 = new ArrayList<>();
        List<Integer> leafSequence2 = new ArrayList<>();
        traversal(root1,leafSequence1);
        traversal(root2,leafSequence2);

        if(leafSequence1.size()!=leafSequence2.size()) return false;
        for(int i=0;i<leafSequence1.size();i++)
        {
            if(leafSequence1.get(i)!=leafSequence2.get(i)) return false;
        }

        return true;
    }
}