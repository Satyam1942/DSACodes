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
    int calcGCD(int a ,int b)
    {
        if(b>a) return calcGCD(b,a);
        
        while(a%b!=0)
        {
            int r = a%b;
            a = b;
            b = r;
            
            
        }
        return b;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        //LOOK AT EDGE CASES
        if(head.next==null) {return head;}
        
        ListNode first = head,second = head.next;
        Queue<Integer> q = new LinkedList<>();
        
        ListNode dummy1 = head, dummy2=head.next;
        while(second!=null)
        {
            q.add(calcGCD(first.val,second.val));    
            first = first.next;
            second = second.next;
        }
        
        while(dummy2!=null)
        {
            ListNode newNode = new ListNode(q.poll());
            dummy1.next = newNode;
            newNode.next = dummy2;
            dummy1 = dummy2;
            dummy2= dummy2.next;
        }
        
        return head;
    }
}