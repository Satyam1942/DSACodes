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
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null)
            return null;

        ListNode temp = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        map.put(0, null);
        int sum = 0;

        while (temp != null) {
            sum += temp.val;

            if (map.containsKey(sum)) {
                ListNode prev = map.get(sum);
                if (prev == null) {
                    head = temp.next;
                    temp.next = null;
                    temp = head;
                    map = new HashMap<>();
                    map.put(0,null);
                    sum = 0;
                } else {
                    ListNode dummy = prev.next;
                    int tempSum = sum;
                    while(dummy!=temp){
                        tempSum += dummy.val;
                        map.remove(tempSum);
                        dummy = dummy.next;
                    }
                    prev.next = temp.next;
                    temp.next = null;
                    temp = prev.next;
                }
            } else {
                map.put(sum, temp);
                temp = temp.next;
            }
        }

        return head;

    }
}