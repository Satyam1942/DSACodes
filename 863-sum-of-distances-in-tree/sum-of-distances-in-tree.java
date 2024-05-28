class Solution {
    public int getNodeCount(int curNode , int childCount[] , int vis[], List<List<Integer>> adjList){
        vis[curNode] = 1;

        int countOfChild = 1;
        int distance = 0;

        for(int i=0;i<adjList.get(curNode).size();i++){
            int adjNode = adjList.get(curNode).get(i);
            if(vis[adjNode]==0){
                distance+= getNodeCount(adjNode,childCount, vis,adjList);
                countOfChild+= childCount[adjNode];
            }
        }

        childCount[curNode] = countOfChild;

        return distance+countOfChild-1;
    }

    public void getDistance(int curNode , int distanceHistory, int childCount[], int vis[] , int sumOfDistanceTree[], List<List<Integer>> adjList ){
        vis[curNode] = 1;
        for(int i=0;i<adjList.get(curNode).size();i++){
            int adjNode = adjList.get(curNode).get(i);
       
            if(vis[adjNode]==0){
                int newDistanceHistory = distanceHistory + childCount[curNode]-childCount[adjNode];
                sumOfDistanceTree[adjNode] = sumOfDistanceTree[curNode]+newDistanceHistory-childCount[adjNode];
                getDistance(adjNode,newDistanceHistory,childCount, vis ,sumOfDistanceTree,adjList);
            }
        }

    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int m = edges.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }    

        for(int i=0;i<m;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        int childNodeCount[] = new int[n];
        int sumOfDistanceTree[] = new int[n];
        int vis[] = new int[n];
        sumOfDistanceTree[0] = getNodeCount(0,childNodeCount,vis,adjList);
     
        Arrays.fill(vis,0);

        getDistance(0,0,childNodeCount,vis, sumOfDistanceTree,adjList);

        return sumOfDistanceTree;

    }
}