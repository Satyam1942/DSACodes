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
    TreeNode findLCA(TreeNode root, int startVal, int destVal) {
        if (root == null || root.val == startVal || root.val == destVal)
            return root;

        TreeNode left = findLCA(root.left, startVal, destVal);
        TreeNode right = findLCA(root.right, startVal,destVal);

        if (left == null && right == null)
            return null;
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }

StringBuilder pathLcaSource(TreeNode lca, int startVal)
{
	if(lca==null) return null;
if(lca.val==startVal) return new StringBuilder("S");
StringBuilder left = pathLcaSource(lca.left,startVal);
StringBuilder right = pathLcaSource(lca.right,startVal);


if(left==null && right==null) return null;
if(left==null) return right.append("U");
else return left.append("U");
}

StringBuilder pathLcaDest(TreeNode lca, int destVal)
{
	if(lca==null) return null;
if(lca.val==destVal) return new StringBuilder("S");
StringBuilder left = pathLcaDest(lca.left,destVal);
StringBuilder right = pathLcaDest(lca.right,destVal);


if(left==null && right==null) return null;
if(left==null) return right.append("R");
else return left.append("L");
}

    public String getDirections(TreeNode root, int startVal, int destVal) {
        TreeNode lca = findLCA(root, startVal, destVal);
        StringBuilder srcPath = pathLcaSource(lca, startVal);
        StringBuilder destPath = pathLcaDest(lca, destVal);
        srcPath.reverse();
        destPath.reverse();
        String path = srcPath.substring(0,srcPath.length()-1)+
                        destPath.substring(0,destPath.length()-1);
        return path;

    }
}