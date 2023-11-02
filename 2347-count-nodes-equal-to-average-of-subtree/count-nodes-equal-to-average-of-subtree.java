/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair
 {
     int sum, count;
     Pair(int sum , int count)
     {
         this.sum = sum;
         this.count = count;
     }
 }

class Solution {
    int  count =0;
    Pair traversal(TreeNode root)
    {
        if(root==null) return new Pair(0,0);
       Pair lVal =  traversal(root.left);
       Pair rVal = traversal(root.right);
        int avg = (lVal.sum +rVal.sum+root.val)/(1+lVal.count+rVal.count);
        if(avg==root.val) count++;

        return new Pair(lVal.sum+rVal.sum+root.val,lVal.count+rVal.count+1); 

    }

    public int averageOfSubtree(TreeNode root) {
        traversal(root);
      return count;
    }
}