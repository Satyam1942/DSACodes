class Solution {
    int postOrderTraversal(int curNode, int subNodes[] , int res[], int vis[] ,  List<List<Integer>> adjList ){
       vis[curNode] =1;
       int noOfSubNodes = 0;
       int resSum = 0;
        for(int i=0;i<adjList.get(curNode).size();i++){
            int adjNode = adjList.get(curNode).get(i);
            if(vis[adjNode]==0){
            noOfSubNodes+=postOrderTraversal(adjNode, subNodes, res, vis,adjList);
            resSum+=res[adjNode];
            }
        }

        res[curNode] = resSum + noOfSubNodes;
        subNodes[curNode] = noOfSubNodes+1;

        return noOfSubNodes+1;
    }

    void preOrderTraversal(int curNode, int prevNode, int totalNodes, int subNodes[], int res[],int vis[] , List<List<Integer>> adjList){
        vis[curNode] = 1;
        if(prevNode!=-1){
            res[curNode] = res[prevNode] - subNodes[curNode] + (totalNodes-subNodes[curNode]);
        }

        for(int i=0;i<adjList.get(curNode).size();i++){
            int adjNode = adjList.get(curNode).get(i);
            if(vis[adjNode]==0){
            preOrderTraversal(adjNode,curNode, totalNodes, subNodes, res, vis, adjList);
            }
        }
    }


    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int res[] = new int[n];
        int subNodes[] = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();

        int vis[] = new int[n];
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        postOrderTraversal(0,subNodes,res,vis,adjList);
        Arrays.fill(vis,0);
        preOrderTraversal(0,-1,n,subNodes,res,vis,adjList);

        return res;
    }
}

/*          
            0   1   2   3   4   5 
  count=    6   1   4   1   1   1
  res =     8   0   3   0   0   0
*/
