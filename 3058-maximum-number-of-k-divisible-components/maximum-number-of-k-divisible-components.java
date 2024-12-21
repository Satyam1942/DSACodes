class Pair {
    int node;
    int val;
    Pair(int node, int val) {
        this.node = node;
        this.val = val;
    }
}

class Solution {

    int maxCuts = 0;

    long dfs(int node, List<List<Pair>> adjList, int[] values, HashSet<Integer> vis, int k) {
        long sum = values[node];
        vis.add(node);

        for(int i=0; i<adjList.get(node).size(); i++) {
            int adjNode = adjList.get(node).get(i).node;
            if(!vis.contains(adjNode)) {
                long val = dfs(adjNode, adjList, values, vis, k);
                sum+=val;
            }
        }

        if(sum%k==0) {
            maxCuts++;
            sum = 0;
        }

        return sum; 
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Pair>> adjList = new ArrayList<>();
        HashSet<Integer> vis = new HashSet<>();

        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(new Pair(v,values[v]));
            adjList.get(v).add(new Pair(u,values[u]));
        }
        
        dfs(0,adjList,values, vis, k);
        return maxCuts;
    }
}

/*

        8
            4
    1
  4   1
        
*/