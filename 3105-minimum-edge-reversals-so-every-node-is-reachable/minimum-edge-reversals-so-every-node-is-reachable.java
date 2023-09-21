class Solution {
    void performDFS(List<List<Integer>> adjListDirectedGraph, List<List<Integer>> adjListNonDirectedGraph,
                    int vis[] , int node , int edgeReversals[])
                    {
                        vis[node]=1;
                        for(int i=0;i<adjListNonDirectedGraph.get(node).size();i++)
                        {
                              
                            int adjNode = adjListNonDirectedGraph.get(node).get(i);
                            if(vis[adjNode]==0)
                              {
                            if(!adjListDirectedGraph.get(node).contains(adjNode))  edgeReversals[0]++;
                     performDFS( adjListDirectedGraph,adjListNonDirectedGraph,vis,adjNode,edgeReversals);
                              }
                        }
                    }

    void dfs(List<List<Integer>> adjListDirectedGraph, List<List<Integer>> adjListNonDirectedGraph,
                    int vis[] , int node , int edgeReversals[])
    {
        vis[node]=1;
        for(int i=0;i<adjListNonDirectedGraph.get(node).size();i++)
        {
                              
        int adjNode = adjListNonDirectedGraph.get(node).get(i);
        if(vis[adjNode]==0)
        {
        if(!adjListDirectedGraph.get(node).contains(adjNode)) 
        {
        edgeReversals[adjNode] = Math.max(edgeReversals[node]-1,0);
        }
        else {edgeReversals[adjNode] = edgeReversals[node]+1; System.out.println("YES");}

        dfs( adjListDirectedGraph,adjListNonDirectedGraph,vis,adjNode,edgeReversals);
              }
         }
    }

    void buildGraphs(int[][] edges,  List<List<Integer>> adjListDirectedGraph,
                    List<List<Integer>> adjListNonDirectedGraph, int n)
    {
        int edgesLength = edges.length;
        for(int i=0;i<n;i++)
        {
            adjListDirectedGraph.add(new ArrayList<>());
            adjListNonDirectedGraph.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {
            adjListDirectedGraph.get(edges[i][0]).add(edges[i][1]);
            adjListNonDirectedGraph.get(edges[i][0]).add(edges[i][1]);
            adjListNonDirectedGraph.get(edges[i][1]).add(edges[i][0]);
        }
    }

    public int[] minEdgeReversals(int n, int[][] edges) {
        List<List<Integer>> adjListDirectedGraph = new ArrayList<>();
        List<List<Integer>> adjListNonDirectedGraph = new ArrayList<>();
        int vis[] = new int[n];
        int edgeReversals[] = new int[n];
        
        buildGraphs(edges,adjListDirectedGraph,adjListNonDirectedGraph,n);


        performDFS(adjListDirectedGraph,adjListNonDirectedGraph,vis,0,edgeReversals);
        Arrays.fill(vis,0);
        dfs(adjListDirectedGraph,adjListNonDirectedGraph,vis,0,edgeReversals);



        return edgeReversals;

    }
}