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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null) return head; 
        ListNode dummy = head;
        ListNode prev = null, next = null, prePosition = null , postPosition = null;
        int count=1;
        if(left==1) prePosition = dummy;
        while(true)
        {
            if(count<left)
            {
                prePosition = dummy;
                dummy = dummy.next;
                count++;
            }

            else if(count==left)
            {
                prev = dummy;
                dummy = prev.next;
                if(dummy!=null) next = dummy.next;
                count++;
            }
            else if(count>left && count<=right)
            {
                dummy.next = prev;
                prev = dummy;
                dummy = next;
                if(next!=null) next = next.next;
                count++;
                
            }
            else if(count>right)
            {
                if(left==1)
                {
                    prePosition.next = dummy;
                    head = prev;
                }
                else
                {
                prePosition.next.next = dummy;
                prePosition.next = prev;
                }
                break;
            }

        }

        return head;
    }
}