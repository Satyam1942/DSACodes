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

class TreePair{
    TreeNode root;
    int height;
    TreePair(TreeNode root, int height){
        this.root = root;
        this.height = height;
    }
}

class Solution {
    void inOrderTraversal(TreeNode root, List<Integer> inOrderTraversal){
        if(root==null)
            return;
        inOrderTraversal(root.left, inOrderTraversal);
        inOrderTraversal.add(root.val);
        inOrderTraversal(root.right, inOrderTraversal);
    }

    TreeNode addNode(int  left, int right,  List<Integer> inOrderTraversal){
        if(left>right)
            return null;
        
        int mid= (left+right)/2;
 
        TreeNode root = new TreeNode(inOrderTraversal.get(mid));
        root.left = addNode(left,mid-1,inOrderTraversal);
        root.right = addNode(mid+1,right,inOrderTraversal);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inOrderTraversal = new ArrayList<>();
        inOrderTraversal(root,inOrderTraversal);
        
        return addNode(0,inOrderTraversal.size()-1,inOrderTraversal);
    }
}