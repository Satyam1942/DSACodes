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
    public ListNode doubleIt(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            st.push(temp);
            temp = temp.next;
        }

        int carry = 0;
        while(!st.isEmpty()){
            ListNode node = st.pop();
            int newVal = (node.val*2 + carry)%10;
            carry = (node.val*2 + carry)/10;
            node.val = newVal;
        }

        if(carry==1){
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }else
            return head;
    }
}