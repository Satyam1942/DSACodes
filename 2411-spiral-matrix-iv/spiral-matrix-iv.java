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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int matrix[][] = new int[m][n];
        for(int row[] : matrix)
            Arrays.fill(row,-1);

        int left =0, right = n-1, top = 0, bottom = m-1;

        while(head!=null){
            for(int i=left;i<=right;i++){
                matrix[top][i] = head.val;
                head = head.next;
                if(head==null)
                    return matrix;
            }
            top++;
            
            for(int i=top;i<=bottom;i++){
                matrix[i][right] = head.val;
                head = head.next;
                if(head==null)
                    return matrix;
            }
            right--;

            for(int i=right;i>=left;i--){
                matrix[bottom][i] = head.val;
                head = head.next;
                if(head==null)
                    return matrix;
            }
            bottom--;

            for(int i=bottom;i>=top;i--){
                matrix[i][left] = head.val;
                head = head.next;
                if(head==null)
                    return matrix;
            }

            left++;
        }

        return matrix;
    }
}