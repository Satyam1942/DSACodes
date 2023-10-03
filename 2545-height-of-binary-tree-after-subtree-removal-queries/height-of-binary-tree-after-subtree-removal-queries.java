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

class Pair
{
    TreeNode parent;
    int height;
    Pair(TreeNode parent, int height)
    {
        this.parent = parent;
        this.height = height;
    }
}

class Solution {
    int getSiblingHeight(HashMap<Integer,Pair> map , TreeNode parentNode, int currentNode)
    {
         int siblingHeight = -1;

        if(parentNode.right!=null && parentNode.left!=null)
        {
        if(parentNode.right.val == currentNode) 
        siblingHeight = map.get(parentNode.left.val).height;
        else siblingHeight = map.get(parentNode.right.val).height;
        }
        return siblingHeight;
    }

    int cacheTreeThroughDFS(HashMap<Integer,Pair> map,TreeNode parent , TreeNode root)
    {
        if(root==null) return 0;
        int leftHeight = cacheTreeThroughDFS(map,root,root.left);
        int rightHeight = cacheTreeThroughDFS(map,root,root.right);
        map.put(root.val,new Pair(parent,Math.max(leftHeight,rightHeight)));
        return 1+Math.max(leftHeight,rightHeight);
    }

    public int[] treeQueries(TreeNode root, int[] queries)
    {
       
        int queryLength = queries.length;
        HashMap<Integer,Pair> map  = new HashMap<>();
        int ans[] = new int[queryLength];
        int heightOfTree= cacheTreeThroughDFS(map,null,root)-1;
       
        for(int i=0;i<queries.length;i++)
        {
            
            int currentNode = queries[i];
            TreeNode parentNode = map.get(queries[i]).parent;
            int heightDueToNode = map.get(queries[i]).height;
            int siblingHeight = getSiblingHeight(map,parentNode,currentNode);
              
             int deltaHeight = (siblingHeight==-1)? heightDueToNode+1:
             Math.max(0,heightDueToNode-siblingHeight);

            currentNode = parentNode.val;
            heightDueToNode=map.get(parentNode.val).height-deltaHeight;
            parentNode = map.get(parentNode.val).parent;

            boolean flag = false;
            while(parentNode!=null && deltaHeight!=0)
            {
            siblingHeight = getSiblingHeight(map,parentNode,currentNode);
            currentNode = parentNode.val;
            heightDueToNode= 1+Math.max(siblingHeight,heightDueToNode);
            if(heightDueToNode == map.get(currentNode).height) {flag =true ; break;}
            parentNode = map.get(parentNode.val).parent;
            
            }

            if(deltaHeight==0 || flag) ans[i] = heightOfTree; 
            else ans[i] = heightDueToNode; 
           
        }

        return ans;
    }
}