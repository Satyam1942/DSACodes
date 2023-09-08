class Pair
{
    int node,weight;
    Pair(int node, int weight)
    {
        this.node = node;
        this.weight = weight;
    }
}

class Triplet{
    int node, weight,stops;
    Triplet(int node, int weight, int stops)
    {
        this.node = node;
        this.weight = weight;
        this.stops = stops;
    }
}



class Solution {
    void buildGraph(List<List<Pair>> adjList, int [][] flights, int n)
    {
        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());

        for(int i=0;i<flights.length;i++)
        {
            adjList.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> adjList = new ArrayList<>();
        buildGraph(adjList,flights,n);

        Queue<Triplet> q= new LinkedList<>(); 
        int cost[] = new int[n];

        Arrays.fill(cost,(int)(1e9));
        q.add(new Triplet(src,0,-1));
        cost[src] = 0; 

        while(!q.isEmpty())
        {
            int curNode = q.peek().node;
            int curWeight = q.peek().weight;
            int noOfStopsTaken = q.peek().stops;
            q.poll();

            if(noOfStopsTaken>=k) continue;
            for(int i=0;i<adjList.get(curNode).size();i++)
            {
                int nextNode = adjList.get(curNode).get(i).node;
                int additionalWeight = adjList.get(curNode).get(i).weight;
                if(cost[nextNode]>additionalWeight+curWeight)
                {
                    cost[nextNode] = additionalWeight+curWeight;
                    q.add(new Triplet(nextNode,cost[nextNode],noOfStopsTaken+1));
                }
            }
        }

        if(cost[dst] == (int)(1e9)) return -1;
        else return cost[dst];
    }
}