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
    void postOrderTraversal(TreeNode root, TreeNode parent,List<TreeNode> ans, HashSet<Integer> toDelete){
        if(root==null)
            return;

        postOrderTraversal(root.left,root,ans,toDelete);
        postOrderTraversal(root.right,root,ans,toDelete);

        if(toDelete.contains(root.val)){
            if(parent!=null){
                if(root==parent.left)
                    parent.left = null;
                else
                    parent.right = null;
            }
            if(root.left!=null)
                ans.add(root.left);
            if(root.right!=null)
                ans.add(root.right);
        }

    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> toDelete = new HashSet<>();
        int numberOfNodesToDelete = to_delete.length;
        List<TreeNode> ans = new ArrayList<>();

        for(int i=0;i<numberOfNodesToDelete;i++){
            toDelete.add(to_delete[i]);
        }

        postOrderTraversal(root,null,ans,toDelete);
        if(!toDelete.contains(root.val))
            ans.add(root);
        return ans;

    }
}