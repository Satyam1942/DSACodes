class Solution {
    int compCount = 0;
    long postOrderTraversal(int curNode, int vis[], int k, int values[], List<List<Integer>> adjList) {
        vis[curNode] = 1;
        long sum = 0;
        for(int i=0; i<adjList.get(curNode).size(); i++) {
            int adjNode = adjList.get(curNode).get(i);
            if(vis[adjNode]==0) {
                sum+= postOrderTraversal(adjNode, vis, k, values, adjList);
            }
        }
        sum+=values[curNode];
        if(sum%k == 0) {
            compCount++;
            return 0;
        } else {
            return sum;
        }
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adjList = new ArrayList<>();
        int vis[] = new int[n];
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<n-1; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        postOrderTraversal(0, vis,k, values, adjList);
        return compCount;
    }
}

/*
    0 1 2 3 4 

    hashmap :
        4
        5
        1
        

*/