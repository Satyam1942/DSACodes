/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode cur = node;
        ListNode next = node.next;

        while(next.next!=null){
            cur.val = next.val;
            cur = next;
            next = next.next;
        }
        cur.val = next.val;
        cur.next = null;
    }
}