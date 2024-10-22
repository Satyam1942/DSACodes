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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            long levelSum = 0;
            while(size-->0) {
                TreeNode temp = q.peek();
                TreeNode left = q.peek().left;
                TreeNode right = q.peek().right;
                q.poll();
                if(left!=null) {
                    q.add(left);
                }
                if(right!=null) {
                    q.add(right);
                }
                levelSum+=temp.val;
            }
            pq.add(levelSum);
            if(pq.size()>k) {
                pq.poll();
            }
        }

        if(pq.size()<k) {
            return -1;
        }

        return pq.poll();
    }
}