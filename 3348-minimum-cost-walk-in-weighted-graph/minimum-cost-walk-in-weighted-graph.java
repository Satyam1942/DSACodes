class Solution {
    void dfs(int node, int vis[], int compNo, HashMap<Integer, Integer> nodeToCompMap, List<List<Integer>> adjList) {
        vis[node] = 1;
        nodeToCompMap.put(node, compNo);
        for(int i=0; i<adjList.get(node).size(); i++) {
            int adjNode = adjList.get(node).get(i);
            if(vis[adjNode] == 0) {
                dfs(adjNode, vis, compNo, nodeToCompMap, adjList);
            }
        }
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int numberOfNodes = n;
        int numberOfEdges = edges.length;
        List<List<Integer>> adjList = new ArrayList<>();
        int vis[] = new int[numberOfNodes];
        HashMap<Integer, Integer> nodeToCompMap = new HashMap<>();
        HashMap<Integer,Integer> compToAndMap = new HashMap<>();

        for(int i=0; i<numberOfNodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<numberOfEdges; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int compNo = 1;
        for(int i=0; i<numberOfNodes; i++) {
            if(vis[i] == 0){
                dfs(i, vis, compNo, nodeToCompMap, adjList);
                compNo++;
            }
        }

        for(int i=0; i<numberOfEdges; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            int curCompNo = nodeToCompMap.get(u);
            if(compToAndMap.containsKey(curCompNo)) {
                int curAnd = compToAndMap.get(curCompNo);    
                compToAndMap.put(curCompNo, curAnd&weight);
            } else {
                compToAndMap.put(curCompNo, weight);
            }
            
        }

        int numberOfQueries = query.length;
        int minCost[] = new int[numberOfQueries];
        for(int i=0; i<numberOfQueries; i++) {
            int u = query[i][0];
            int v = query[i][1];
            int comp1 = nodeToCompMap.get(u);
            int comp2 = nodeToCompMap.get(v);

            if(comp1!=comp2) {
                minCost[i] = -1;
            } else {
                int curCompNo = nodeToCompMap.get(u);
                int andVal = compToAndMap.get(curCompNo);
                minCost[i] = andVal;
            }
        }

        return minCost;
    }
}


/*
    Because we need to find a walk
    Within a component, the answer for any 2 pair of vertices will be same
    just take AND of all weights , as AND of x and y <= min(x,y) ; we will 
    eventually get min And

    Solution: 
    perform DFS from node to get components. Add nodes of a component 
    in some data structure along with the AND value. 
*/