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
    TreeNode node;
    int depth;
    Pair(TreeNode node, int depth){
        this.node = node;
        this.depth = depth;
    }
    @Override
    public String toString(){
        return "("+node.val+","+depth+")";
    }
}

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        List<Pair> preorderTraversal = new ArrayList<>();
        int depth =0;
        int length = traversal.length();
        StringBuilder number = new StringBuilder();

        for(int i=0;i<length;){
            char token = traversal.charAt(i);
            while(i<length && token>=48 && token<=57){
                token = traversal.charAt(i);
                if(token=='-'){
                    TreeNode newNode = new TreeNode(Integer.valueOf(number.toString()),null,null);
                    number = new StringBuilder();
                    preorderTraversal.add(new Pair(newNode,depth));
                    depth = 0;
                    break;
                }
                number.append(token-48);
                i++;
            }
            while(i<length && token=='-'){
                token = traversal.charAt(i);
                if(token!='-')
                    break;
                depth++;
                i++;
            }
        }

        if(!number.toString().equals("")){
        TreeNode newNode = new TreeNode(Integer.valueOf(number.toString()),null,null);
         preorderTraversal.add(new Pair(newNode,depth));
        }
        
        HashMap<Integer,Queue<TreeNode>> map = new HashMap<>();
        for(int i=0;i<preorderTraversal.size();i++){
            depth = preorderTraversal.get(i).depth;
            TreeNode node = preorderTraversal.get(i).node;
            if(!map.containsKey(depth))
                map.put(depth,new LinkedList<>());
            map.get(depth).add(node);
        }

        TreeNode head = preorderTraversal.get(0).node;
        // System.out.println(preorderTraversal);
        for(int i=1;i<preorderTraversal.size();i++){
            TreeNode curNode = preorderTraversal.get(i).node;
            int curDepth = preorderTraversal.get(i).depth;
            // System.out.println(curDepth);
            TreeNode parent = map.get(curDepth-1).peek();
            if(parent.left!=null){
                parent.right = curNode;
                map.get(curDepth-1).poll();
            }else
                parent.left = curNode;
            
            while(map.get(curDepth).peek()!=curNode)
                map.get(curDepth).poll();
        }

        return head;
    }
}
/*
    (1,0)
    (2,1) ; 
    (3,2) ;
    (5,1)
    (6,2)
    (9,3)
    (7,2)

    0->
    1->2,5
    2->3,4,6,7
    3-> 8

       1
    2        5
 3     4   6    7

 whenever I go to smaller level in my list i  need to make sure that previous nodes were polled from queue
 */