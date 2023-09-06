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
    int getLength(ListNode head)
    {
        ListNode temp = head;
        int len =0;
        while(temp!=null)
        {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = getLength(head);
        int sizeNormal  = len/k;
        int nodeNormal =  k- len%k;
        int sizeExtra  =  sizeNormal+1;
        int nodeExtra = len%k;

        ListNode temp = head, prev = null;
        ListNode[] ans = new ListNode[k];
        int pointer =0;
        
        while(nodeExtra>0)
        {
            int loopTill = sizeExtra;
           
            ans[pointer] = temp;

            while(loopTill>1)
            {
                temp = temp.next;
                loopTill--;
            }

            prev = temp;
            temp = temp.next;
            prev.next = null;  

            nodeExtra--;  
            pointer++;    
        }

        while(nodeNormal>0)
        {
            int loopTill = sizeNormal;
            ans[pointer] = temp;

            while(loopTill>1)
            {
                temp = temp.next;
                loopTill--;
            }
            
            
            if(temp!=null)
            {
            prev = temp;
            temp = temp.next;
            prev.next = null; 
            }

            nodeNormal--;
            pointer++;
        }

        return ans;

    }
}