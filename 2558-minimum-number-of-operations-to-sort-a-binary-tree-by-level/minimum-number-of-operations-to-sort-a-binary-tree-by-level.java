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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int swapCount = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            TreeMap<Integer,Integer> sortedLevel = new TreeMap<>();
            List<Integer> level = new ArrayList<>();
            while(size-->0) {
                TreeNode node = q.poll();
                if(node.left!=null) {
                    q.add(node.left);
                }
                if(node.right!=null) {
                    q.add(node.right);
                }
                level.add(node.val);
                sortedLevel.put(node.val, level.size()-1);
            }

            int index = 0;
            for(Map.Entry<Integer,Integer> i: sortedLevel.entrySet()) {
                int nodeVal = i.getKey();
                int nodeIndex = i.getValue();
                if(level.get(index)!=nodeVal) {
                    int temp = level.get(index);
                    level.set(index, nodeVal);
                    level.set(nodeIndex, temp);
                    sortedLevel.put(temp, nodeIndex);
                    swapCount++;
                }
                index++;
            }
     
        }

        return swapCount;
    }
}

/*
    7,6,8,5
    5,6,7,8

    7, 6, 5, 4
    4, 5, 6, 7

        49
    45        1
  20  46     15   39
27         25   

*/