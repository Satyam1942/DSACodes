/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    void dfs(Node root,List<Integer> postOrderTraversalList){
        if(root==null)
            return;
        List<Node> children = root.children;
        for(Node child:children){
            dfs(child,postOrderTraversalList);
        }
        postOrderTraversalList.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        List<Integer> postOrderTraversalList = new ArrayList<>();
        dfs(root,postOrderTraversalList);
        return postOrderTraversalList;
    }
}