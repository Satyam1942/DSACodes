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
class FindElements {
    HashSet<Integer> elements;
    void recoverElements(TreeNode root, HashSet<Integer> elements) {
        if(root == null) {
            return;
        }
        int val = root.val;
        elements.add(val);
        if(root.left!=null) {
            root.left.val = 2*val+1;
            recoverElements(root.left, elements);
        } 
        if(root.right!=null) {
            root.right.val = 2*val+2;
            recoverElements(root.right, elements);
        }
    }

    public FindElements(TreeNode root) {
        elements = new HashSet<>();    
        root.val = 0;
        recoverElements(root, elements);
    }
    
    public boolean find(int target) {
        return elements.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */