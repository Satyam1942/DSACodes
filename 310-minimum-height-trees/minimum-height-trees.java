class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) {
        return Arrays.asList(0);
    }
    
    List<List<Integer>> adj = new ArrayList<>();
    int[] inlinks = new int[n];
    createGraph(n, edges, adj, inlinks);
     
    List<Integer> leaves = new LinkedList<>();
    for(int i = 0; i < inlinks.length; i++) {
        if (inlinks[i] == 1) {
            leaves.add(i);
        }
    }
    
    while (n > 2) {
        List<Integer> newLeaves = new ArrayList<>();
        for (int leave : leaves) {
            for (int nb : adj.get(leave)) {
                inlinks[nb]--;
                if (inlinks[nb] == 1) {
                    newLeaves.add(nb);
                }
            }
        }
        n -= leaves.size();
        leaves = newLeaves;
    }
    
    return leaves;
}

public void createGraph(int n, int[][] edges, List<List<Integer>> adj, int[] inlinks) {
    for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<Integer>());
    }
    for (int[] e : edges) {
        adj.get(e[0]).add(e[1]);
        adj.get(e[1]).add(e[0]);
        inlinks[e[0]]++;
        inlinks[e[1]]++;
    }
}
}