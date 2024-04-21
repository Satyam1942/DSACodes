class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int vis[] = new int[n];
        q.add(source);
        vis[source] = 1;

        while(!q.isEmpty()){
            int curNode = q.poll();
            if(curNode==destination)
                return true;
            for(int i=0;i<adjList.get(curNode).size();i++){
                int adjNode = adjList.get(curNode).get(i);
                if(vis[adjNode]==0){
                    vis[adjNode]=1;
                    q.add(adjNode);
                }
            }
        }

        return false;
    }
}