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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;

        ListNode prev = null;
        ListNode cur  = head;
        ListNode next = head.next;

        while(next!=null)
        {
            if(cur.val!=next.val)
            {
              prev = cur;
              cur = next;
            }
            else
            {
                
                while(next!=null && next.val==cur.val) next = next.next;
               
                if(prev!=null) prev.next = next;
                else head = next;

                cur = next;
            }

            if(next!=null) next = next.next;
        }

        return head;

    }
}