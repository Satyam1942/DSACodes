/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy=head;
        HashMap<Node,Node> map = new HashMap<>();
        
        while(dummy!=null)
        {
            Node newNode = new Node(dummy.val);
            map.put(dummy,newNode);
            dummy = dummy.next;
        }
        
        Node ans = head;
        while(head!=null)
        {
            Node newNode = map.get(head);
            if(head.random !=null)
            newNode.random = map.get(head.random);
            else newNode.random =null;
            
            newNode.next = map.get(head.next);
            head =head.next;
        }

           return map.get(ans); 
    }
}