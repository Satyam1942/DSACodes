class Solution {
    int dfs(int curNode, int vis[], List<List<Integer>> adjList) {
        vis[curNode] = 1;

        int countNodes = 0;
        for (int i = 0; i < adjList.get(curNode).size(); i++) {
            int adjNode = adjList.get(curNode).get(i);

            if (vis[adjNode] == 0)
                countNodes += dfs(adjNode, vis, adjList);
        }
        return 1 + countNodes;
    }

    void buildGraph(int n, int edges[][], List<List<Integer>> adjList) {

        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

    }

    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        buildGraph(n, edges, adjList);

        int vis[] = new int[n];

        List<Integer> noOfNodesInComponent = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                int noOfNodes = dfs(i, vis, adjList);
                noOfNodesInComponent.add(noOfNodes);
            }
        }

        long noOfPairs = 0;

        int noOfComponents = noOfNodesInComponent.size();
        for (int i = 0; i < noOfComponents; i++) {
            int val = noOfNodesInComponent.get(i);
            noOfPairs -= ((long)val * ((long)val - 1)) / 2;
        }

        noOfPairs += ((long)n * ((long)n - 1)) / 2;

        return noOfPairs;

    }
}