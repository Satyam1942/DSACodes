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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val-b.val));
        int noOfLists = lists.length;


        for(int i=0;i<noOfLists;i++){
            if(lists[i]!=null)
                pq.add(lists[i]);
        }
        if(pq.isEmpty())
            return null;

        ListNode newListHead = new ListNode(pq.peek().val);
        ListNode  temp = pq.poll();
        if(temp.next!=null)
            pq.add(temp.next);

        ListNode dummy = newListHead;
        while(!pq.isEmpty()){
            ListNode newNode = new ListNode(pq.peek().val);
            temp = pq.poll();
            if(temp.next!=null)
                pq.add(temp.next);
            dummy.next = newNode;
            dummy = dummy.next;
        }

        return newListHead;
    }
}

/*
    1,3,4

    1->1->
 */