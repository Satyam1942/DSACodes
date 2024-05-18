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
class Pair{
    int sizeOfSubtree;
    int numberOfCoins;
    Pair(int sizeOfSubtree, int numberOfCoins){
        this.sizeOfSubtree = sizeOfSubtree;
        this.numberOfCoins = numberOfCoins;
    }
}

class Solution {
    int res = 0;
    Pair postOrderTraversal(TreeNode root){
        if(root==null)
            return new Pair(0,0);
        Pair leftPair  = postOrderTraversal(root.left);
        Pair rightPair = postOrderTraversal(root.right);

        int extraCoinsLeft = Math.abs(leftPair.sizeOfSubtree-leftPair.numberOfCoins);
        int extraCoinsRight = Math.abs(rightPair.sizeOfSubtree-rightPair.numberOfCoins);
        
        res += extraCoinsLeft+extraCoinsRight;
        return new Pair(1+leftPair.sizeOfSubtree+rightPair.sizeOfSubtree , root.val+ leftPair.numberOfCoins+ rightPair.numberOfCoins);
    }

    public int distributeCoins(TreeNode root) {
        postOrderTraversal(root);
        return res;
    }
}