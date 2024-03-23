/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
    
        ListNode prev = slow;
        ListNode cur = slow.next;
        ListNode next = slow.next.next;

        slow.next = null;

        while (cur != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            if(next!=null)
                next = next.next;
        }

      
        ListNode front = head;
        ListNode last = prev;
        System.out.println(prev.val);

        while (  front != null && last != null && front.next!=last) {
            ListNode tempFront = front.next;
            ListNode tempBack = last.next;
            front.next = last;
            last.next = tempFront;

            front = tempFront;
            last = tempBack;
        }

    }
}