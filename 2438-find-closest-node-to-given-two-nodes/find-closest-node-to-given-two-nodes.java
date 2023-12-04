class Solution {
    void dfs(List<List<Integer>> adjList , int vis[] , int curNode ,int level, 
            HashMap<Integer,Integer> dfsSequence )
    {
        vis[curNode] = 1;
        dfsSequence.put(curNode,level);

        for(int i=0;i<adjList.get(curNode).size();i++)
        {
            int adjNode = adjList.get(curNode).get(i);
            if(vis[adjNode]==0)
            {
                dfs(adjList,vis,adjNode,level+1,dfsSequence);
            }
        }
    }


    public int closestMeetingNode(int[] edges, int node1, int node2) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<edges.length;i++)
        {
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++)
        {
            if(edges[i]==-1) continue;
            adjList.get(i).add(edges[i]);
        }

        int vis1[] = new int[edges.length];
        int vis2[] = new int[edges.length];
        dfs(adjList,vis1,node1,0,map1);
        dfs(adjList,vis2,node2,0,map2);

        int minDist = Integer.MAX_VALUE, minDistNode = Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> i : map1.entrySet())
        {
            int node = i.getKey();
            int index = i.getValue();
            if(map2.containsKey(node))
            {
            int index2 = map2.get(node);
            int maxDist = Math.max(index,index2);
            if(minDist>maxDist)
            {
                minDist = maxDist;
                minDistNode = node;
            }
            else if(minDist==maxDist) minDistNode = Math.min(minDistNode,node);
            }
        }

        if(minDistNode==Integer.MAX_VALUE) return -1;
        return minDistNode;
    }
}
