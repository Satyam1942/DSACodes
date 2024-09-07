/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    boolean dfs(TreeNode root, boolean hasStarted, ListNode head,  ListNode temp){
        if(temp == null)
            return true;
        if(root==null)
            return false;

        boolean leftMatch = false;
        boolean rightMatch = false;
        boolean leftNotMatch = false;
        boolean rightNotMatch = false;

        if(!hasStarted) {
            leftNotMatch = dfs(root.left, false, head,head);
            rightNotMatch = dfs(root.right,false, head,head);
        }

        if(root.val == temp.val){
            leftMatch = dfs(root.left, true, head, temp.next);
            rightMatch = dfs(root.right,true, head, temp.next);
        }
            

        return leftMatch||rightMatch||leftNotMatch||rightNotMatch;
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        boolean hasSubPath = dfs(root,false,head,head);
        return hasSubPath;
    }
}