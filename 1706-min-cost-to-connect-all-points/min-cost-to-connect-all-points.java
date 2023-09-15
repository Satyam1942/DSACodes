class Pair{
    int node , distance;
    Pair(int node, int distance)
    {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {

    int calcDistance(int[]coordinate1 , int[] coordinate2)
    {
        int x1 = coordinate1[0];
        int y1=  coordinate1[1];
        int x2 = coordinate2[0];
        int y2  = coordinate2[1];

        return Math.abs(x1-x2)+ Math.abs(y2-y1);
    }

    public void prepareAdjacencyList(List<List<Pair>> adjList , int n , int [][] points)
    {
        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int distance = calcDistance(points[i],points[j]);
                adjList.get(i).add(new Pair(j,distance));
                adjList.get(j).add(new Pair(i,distance));
            }
        }
    }

    int createMinimumSpanningTree(List<List<Pair>> adjList)
    {
        int len = adjList.size();
        int vis[] = new int[len];
        int cost=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->(x.distance - y.distance));
        
        pq.add(new Pair(0,0));

        while(!pq.isEmpty())
        {
            int curNode = pq.peek().node;
            int weight = pq.peek().distance;
            pq.poll();

            if(vis[curNode]==1) continue;
            vis[curNode]=1;
            cost+=weight;

            for(int i = 0;i<adjList.get(curNode).size();i++)
            {
                int adjNode = adjList.get(curNode).get(i).node;
                int adjWeight = adjList.get(curNode).get(i).distance;
                pq.add(new Pair(adjNode , adjWeight));
            }

        }

        return cost;
    }

    public int minCostConnectPoints(int[][] points) {
        List<List<Pair>> adjList = new ArrayList<>();
        int n = points.length;
        
        prepareAdjacencyList(adjList, n , points);

        return createMinimumSpanningTree(adjList);




    }
}