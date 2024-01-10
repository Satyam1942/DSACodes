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
    void dfs(TreeNode root, TreeNode parent, HashMap<Integer, List<TreeNode>> adjList) {

        if (root == null)
            return;
        if (!adjList.containsKey(root.val))
            adjList.put(root.val, new ArrayList<>());

        if (parent != null)
            adjList.get(root.val).add(parent);
        if (root.left != null)
            adjList.get(root.val).add(root.left);
        if (root.right != null)
            adjList.get(root.val).add(root.right);

        dfs(root.left, root, adjList);
        dfs(root.right, root, adjList);
    }

    public int amountOfTime(TreeNode root, int startVal) {

        HashMap<Integer, List<TreeNode>> adjList = new HashMap<>();
        dfs(root, null, adjList);

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();

        q.add(startVal);
        vis.add(startVal);

        int time = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int curNode = q.poll();
                List<TreeNode> neighbourList = adjList.get(curNode);
                for (TreeNode neighbour : neighbourList) {
                    if (!vis.contains(neighbour.val)) {
                        vis.add(neighbour.val);
                        q.add(neighbour.val);
                    }
                }
            }
            time++;
        }

        return time-1;

    }
}