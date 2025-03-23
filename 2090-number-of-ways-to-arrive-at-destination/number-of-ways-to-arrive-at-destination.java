class Pair{
    int node ;
    int weight;
    Pair(int node ,int weight)
    {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
  void  djikstra(long dis[],  List<List<Pair>> adjList,long count[])
    {
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)-> a.weight - b.weight);
        q.add(new Pair(0,0));
        dis[0] = 0;
        count[0]=1;
        while(!q.isEmpty())
        {
            int curNode = q.peek().node;
            long curDist = (long)q.peek().weight;
            q.remove();
            for(int i =0;i<adjList.get(curNode).size();i++)
            {
                int adjNode = adjList.get(curNode).get(i).node;
                long additionalDistance =  (long)adjList.get(curNode).get(i).weight;
                if(additionalDistance+curDist < dis[adjNode])
                {
                   dis[adjNode]= additionalDistance+curDist;
                   count[adjNode]=count[curNode]%((int) 1e9 + 7);
              
                   q.add(new Pair(adjNode,(int)dis[adjNode]));
                }
              else  if(additionalDistance+curDist == dis[adjNode])
                {
                   
                count[adjNode] = (count[adjNode] + count[curNode])%((int) 1e9+7);
               
                 }
            }
        }

    }
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int i= 0;i<roads.length;i++)
        {
            adjList.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]) );
            adjList.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]) );
        }
       
        long dis[] = new long[n];
        long count[] = new long[n];
        for(int i=0;i<n;i++) dis[i] =Long.MAX_VALUE;

    djikstra(dis,adjList,count);
    return (int)count[n-1] %((int) 1e9 + 7);
    }

}