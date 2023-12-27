class Solution {
    boolean dfs(int curNode, int[][] graph ,int vis[] , int outdegree[], boolean isSafeNode[])
    {
        vis[curNode] = 1;
        boolean res = true;

        if(outdegree[curNode]==0) return isSafeNode[curNode] = true; 

        for(int i=0;i<graph[curNode].length;i++)
        {
            int adjNode = graph[curNode][i];
            if(vis[adjNode]==0)
            {
                res = res && dfs(adjNode,graph,vis,outdegree,isSafeNode);
            }
            else 
            {
                res = res && isSafeNode[adjNode];
            }

            if(!res) return isSafeNode[curNode] = false;
        }

        return isSafeNode[curNode] = true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int outdegree[] = new int[n];

        for(int i=0;i<graph.length;i++)
        {
            outdegree[i] = graph[i].length;
        } 

        int vis[] = new int[n];
        boolean isSafeNode[] = new boolean[n];
        Arrays.fill(isSafeNode,false);

        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,graph,vis,outdegree,isSafeNode);
            }
        }

        List<Integer> safeNodes=  new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(isSafeNode[i]) safeNodes.add(i);
        }

        Collections.sort(safeNodes);

        return safeNodes;
    }
}