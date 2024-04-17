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

class CustomComparator implements Comparator<StringBuilder> {
    public int compare(StringBuilder a , StringBuilder b){
        return a.compareTo(b);
    }
}

class Solution {
    void dfsTraversal(TreeNode root, StringBuilder sb, PriorityQueue<StringBuilder> pq) {
        if(root==null){
            return;
        }

        char val = (char)(root.val+97);
        sb.append(val);
        dfsTraversal(root.left,sb,pq);
        dfsTraversal(root.right,sb,pq);
        if(root.left==null && root.right==null){
            StringBuilder temp = new StringBuilder(sb.toString());
            temp.reverse();
            pq.add(temp);
        }
        sb.deleteCharAt(sb.length()-1);
    }

    public String smallestFromLeaf(TreeNode root) {
        PriorityQueue<StringBuilder> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        dfsTraversal(root,sb,pq);
        return pq.poll().toString();
    }
}