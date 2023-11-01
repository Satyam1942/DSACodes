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
class Solution {
   HashMap<Integer,Integer> map = new HashMap<>();
    void preorderTraversal(TreeNode root)
    {
        if(root==null) return ;

        map.put(root.val,map.getOrDefault(root.val,0)+1);
       preorderTraversal(root.left);
       preorderTraversal(root.right);
    
    }
    public int[] findMode(TreeNode root) {
        preorderTraversal(root);
        List<Integer> list = new ArrayList<>();
        int maxFreq = 0;
       for(Map.Entry<Integer,Integer> i: map.entrySet())
       {    
           maxFreq = Math.max(maxFreq,i.getValue());
       }    
       for(Map.Entry<Integer,Integer> i: map.entrySet())
       {   
           if(i.getValue()==maxFreq)
           list.add(i.getKey());
       }    

       int arr[] = new int[list.size()];
       for(int i=0;i<list.size();i++) arr[i] = list.get(i);
       return arr;
       
    }
}