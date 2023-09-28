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
    TreeNode traversal(TreeNode root, TreeNode prev, List<Integer> ans)
    {
        if(root==null) return prev; 
        if(root.left==null && root.right==null)
        {
            return null;
        }

        TreeNode left = traversal(root.left,root,ans);
        if(left==null)
        {
             ans.add(root.left.val);
             root.left = null;
        } 
        TreeNode right = traversal(root.right,root,ans);
        if(right==null)
        {
            ans.add(root.right.val);
            root.right=null;
        }
        return root;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        //Tree can't be empty
        List<List<Integer>> ans = new ArrayList<>();
        while(root!=null)
        {
            List<Integer> temp = new ArrayList<>();
            TreeNode head  = traversal(root,null,temp);
            if(head==null) temp.add(root.val);
            ans.add(new ArrayList<>(temp));
            root = head;
        }

        return ans;
    }
}