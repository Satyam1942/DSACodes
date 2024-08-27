class Pair{
    int node; double weight ;
   
    Pair(int node , double weight)
    {
     this.node = node;
     this.weight = weight;
    }
}
class Solution {
   double  djikstra(List<List<Pair>> adjList, int size, int start ,int end)
    {
        Queue<Integer> q = new LinkedList<>();
        double probablity[] = new double[size];
        q.add(start);
        probablity[start] =1f;

        while(!q.isEmpty())
        {
            int curNode=q.poll();
            double curProbab= probablity[curNode];
             for(int i=0;i<adjList.get(curNode).size();i++)
             {
                 int adjNode= adjList.get(curNode).get(i).node;
                double edgeProbablity = adjList.get(curNode).get(i).weight;
                double newProbab = edgeProbablity * curProbab;
                if(newProbab>probablity[adjNode]){ 
                    probablity[adjNode] = newProbab; 
                    q.add(adjNode);
                }
             }
        }
        return probablity[end];
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            List<List<Pair>> adjList = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                adjList.add(new ArrayList<>());
            }
            for(int i=0;i<edges.length;i++)
            {
              adjList.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]));
              adjList.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]));
            }

            return djikstra(adjList,n,start,end);
            }
}