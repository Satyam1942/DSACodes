class Solution {
    int dfsCycle(List<Integer> edges, int dist[],int vis[] , int node, int height )
    {
        vis[node] =1;
        height++;
        if(vis[edges.get(node)]==0)
        {
           dist[node] =  dfsCycle(edges,dist,vis,edges.get(node),height);
           return dist[node];
        }
        dist[node] = height;
        return height;
    }

    void dfsNoCycle(List<Integer> edges, int dist[],int vis[] , int node)
    {
        vis[node]=1;
        if(vis[edges.get(node)]==0) dfsNoCycle(edges,dist,vis,edges.get(node));
        dist[node] = 1+dist[edges.get(node)];
    }

    void findCyclicElements( HashSet<Integer> topoSort ,  int indegree[] ,int n,List<Integer> edges)
    {
        Queue<Integer> q = new LinkedList<>();
        int vis[] = new int[n];
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
                vis[i]=1;
            }
        }
        
        while(!q.isEmpty())
        {
            int curNode = q.poll();
            topoSort.add(curNode);
            int adjNode =  edges.get(curNode);
            indegree[adjNode]--;
            if(indegree[adjNode]==0)
            {
                vis[adjNode]=1;
                q.add(adjNode);
            } 
        }
    }

    public int[] countVisitedNodes(List<Integer> edges) {
        
        int numberOfNodes = edges.size();
        int indegree[] = new int[numberOfNodes];
        int vis[] =  new int[numberOfNodes];
        HashSet<Integer> topoSort = new HashSet<>();
        int dist[] = new int[edges.size()];

        for(int i=0;i<edges.size();i++)
        {
            indegree[edges.get(i)]++;
        }

        findCyclicElements(topoSort,indegree,numberOfNodes,edges);

        for(int i=0;i<numberOfNodes;i++)
        {
            if(!topoSort.contains(i) && vis[i]==0)dfsCycle(edges,dist,vis,i,0);
        }

        System.out.println(Arrays.toString(dist));
        for(int i=0;i<numberOfNodes;i++)
        {
            if(vis[i]==0)dfsNoCycle(edges,dist,vis,i);
        }


        return dist;
    }
}