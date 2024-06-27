class Solution {
    int findLowestCommonAncestor(int srcNode, int destNode1, int destNode2 , int vis[], List<List<Integer>> adjList){
        vis[srcNode] = 1;
        if(srcNode==destNode1 || srcNode == destNode2){
            return srcNode;
        }
        
        int node = -1;
        int count = 0;
        for(int i=0;i<adjList.get(srcNode).size();i++){
            int adjNode = adjList.get(srcNode).get(i);
            if(vis[adjNode]==0){
                int temp = findLowestCommonAncestor(adjNode,destNode1,destNode2,vis,adjList);
                if(temp!=-1){
                    node = temp;
                    count++;
                }
            }
        }
        
        if(count==2)
            return srcNode;
        else
            return node;
       
    }

    public int[] closestNode(int n, int[][] edges, int[][] query) {
        List<List<Integer>> adjList = new ArrayList<>();
        int noOfEdges = edges.length;
        int noOfNodes = n;

        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        int noOfQueries = query.length;
        int ans[] = new int[noOfQueries];
        for(int i=0;i<noOfQueries;i++){
            int srcNode = query[i][0];
            int destNode1 = query[i][1];
            int destNode2 = query[i][2];
            int vis[] = new int[noOfNodes];
            ans[i] = findLowestCommonAncestor(srcNode,destNode1, destNode2,vis,adjList);
        }

        return ans;
    }
}

/*
    there are 3 kinds of nodes
    perform dfs traversal for whole tree 

*/