/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    boolean checkIfPalindromPossible(int digitMap) {
        boolean flag = false;
        for(int i=1;i<=9;i++){
            if((digitMap&(1<<i))!=0)
                {
                    if(flag)
                        return false;
                    else 
                        flag = true;
                }
        }
        return true;
    }

    int traversal(TreeNode node, int digitMap) {

        if (node == null)
            return 0;

        if (node.left == null && node.right == null) {
            int nodeVal = node.val;
             digitMap = (digitMap^(1<<nodeVal));

            int res = 0;

            if (checkIfPalindromPossible(digitMap))
                res = 1;

            digitMap = (digitMap^(1<<nodeVal));

            return res;
        }

        int leftCount = 0, rightCount = 0;

        int nodeVal = node.val;
        digitMap = (digitMap^(1<<nodeVal));

        leftCount = traversal(node.left, digitMap);
        rightCount = traversal(node.right, digitMap);

         digitMap = (digitMap^(1<<nodeVal));

        return leftCount + rightCount;

    }

    public int pseudoPalindromicPaths(TreeNode root) {
        int digitMap = 0;
        return traversal(root, digitMap);
    }
}