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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> maxList = new ArrayList<>();
        if(root==null) return maxList;

        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            int maxTemp = Integer.MIN_VALUE;
            while(size-->0)
            {
                TreeNode curNode = q.poll();
                if(curNode.left!=null) q.add(curNode.left);
                if(curNode.right!=null) q.add(curNode.right);
                maxTemp = Math.max(maxTemp,curNode.val);
            }
            maxList.add(maxTemp);
        }

        return maxList;
    }
}