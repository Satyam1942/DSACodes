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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        if(head==null || head.next ==null)
            return head;
        int length = 0;

        while(temp!=null){
           length++;
            temp = temp.next;
        }

        int numberOfRotations = k%length;
        ListNode prev = head;
        int pointer = 1;
       
        while(pointer!=length-numberOfRotations){
            pointer++;
            prev = prev.next;
        }
 
        ListNode lastNode = head;
        while(lastNode.next!=null)
            lastNode = lastNode.next;

        ListNode newHead = prev.next;
     
        if(newHead!=null)
            lastNode.next = head;
        else
            newHead = head;

        prev.next = null;

        return newHead;
    }
}