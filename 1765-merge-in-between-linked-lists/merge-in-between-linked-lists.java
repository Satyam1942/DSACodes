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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1;
        ListNode end = list1;

        b++;
        a--;

        int dif = b-a;
        ListNode list2End = list2;

        while(list2End.next!=null){
            list2End = list2End.next;
        }

        while(dif-->0){
            b--;
            end = end.next;
        }

        while(b-->0){
            start = start.next;
            end = end.next;
        }

        
        start.next = list2;
        list2End.next = end;
        
        return list1;
    }
}