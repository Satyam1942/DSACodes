/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode,Integer> vis = new HashMap<>();
        while(head!=null)
        {
            int val = vis.getOrDefault(head,0);
            vis.put(head,val+1);
            if(vis.get(head)>1) return true;
            head =head.next;
        } 
        return false;
    }
}