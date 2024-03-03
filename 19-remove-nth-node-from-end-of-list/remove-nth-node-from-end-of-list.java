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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode cur = head;
        ListNode prev = null;
        ListNode prevNext = head;
        while(cur!=null)
        {
            if(n>0)
            {
                cur = cur.next;
                n--;
            }
            else {cur=cur.next;
                prev=prevNext;
                prevNext= prevNext.next;
                }
        }

    if(prevNext==head) return head.next;
    

      prev.next = prevNext.next;
      prevNext.next =null;
        

        return head;
    }
}