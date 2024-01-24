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

    boolean checkIfPalindromPossible(HashMap<Integer, Integer> digitMap) {

        int lengthOfNum = 0;
        boolean flag = false;

        for (Map.Entry<Integer, Integer> i : digitMap.entrySet()) {
             int freq = i.getValue();
             lengthOfNum+=freq;
        }

        for (Map.Entry<Integer, Integer> i : digitMap.entrySet()) {
            int freq = i.getValue();
            if (freq % 2 != 0) {
                if (lengthOfNum % 2 == 0)
                    return false;
                else {
                    if (flag)
                        return false;
                    else
                        flag = true;
                }
            }
        }

        return true;
    }

    int traversal(TreeNode node, HashMap<Integer, Integer> digitMap) {

        if (node == null)
            return 0;

        if (node.left == null && node.right == null) {
            int nodeVal = node.val;
            int freq = digitMap.getOrDefault(nodeVal, 0);
            digitMap.put(nodeVal, freq + 1);

            int res = 0;

            if (checkIfPalindromPossible(digitMap))
                res = 1;

            if (freq == 0)
                digitMap.remove(nodeVal);
            else
                digitMap.put(nodeVal, freq);

            return res;
        }

        int leftCount = 0, rightCount = 0;

        int nodeVal = node.val;
        int freq = digitMap.getOrDefault(nodeVal, 0);
        digitMap.put(nodeVal, freq + 1);

        leftCount = traversal(node.left, digitMap);
        rightCount = traversal(node.right, digitMap);

        if (freq == 0)
            digitMap.remove(nodeVal);
        else
            digitMap.put(nodeVal, freq);

        return leftCount + rightCount;

    }

    public int pseudoPalindromicPaths(TreeNode root) {
        HashMap<Integer, Integer> digitMap = new HashMap<>();
        return traversal(root, digitMap);
    }
}