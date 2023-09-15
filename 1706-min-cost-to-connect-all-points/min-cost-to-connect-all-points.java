class DisjointSet
{
    List<Integer> ultParent;
    List<Integer> size;

    DisjointSet(int n)
    {
        ultParent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            ultParent.add(i);
            size.add(0);
        }
    }

    int findUltimateParent(int node)
    {
        if(ultParent.get(node)== node) return node;

        int ultimateParent = findUltimateParent(ultParent.get(node));
        ultParent.set(node,ultimateParent);
        return ultimateParent;
    }

    void unionBySize(int u, int v)
    {
        int ultimU = findUltimateParent(u);
        int ultimV = findUltimateParent(v);

        if(ultimU==ultimV) return;

        if(size.get(ultimU)<size.get(ultimV))
        {
            ultParent.set(ultimU,ultimV);
            size.set(ultimV,size.get(ultimU)+size.get(ultimV));
        }
        else
        {
            ultParent.set(ultimV,ultimU);
            size.set(ultimU,size.get(ultimU)+size.get(ultimV));    
        }
    }
}

class Triplet{
    int node1, node2 , distance;
    Triplet(int node1, int node2, int distance)
    {
        this.node1 = node1;
        this.node2 = node2;
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

    public void prepareAdjacencyList(List<Triplet> adjList , int n , int [][] points)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int distance = calcDistance(points[i],points[j]);
                adjList.add(new Triplet(j,i,distance));
                adjList.add(new Triplet(i,j,distance));
            }
        }

        Collections.sort(adjList, (a,b)->(a.distance-b.distance));
    }

    int createMinimumSpanningTree(List<Triplet> adjList)
    {
        int len = adjList.size();
        DisjointSet dsu = new DisjointSet(len);
        int cost=0;
        for(int i=0;i<len;i++)
        {
            int u = adjList.get(i).node1;
            int v = adjList.get(i).node2;
            int wt = adjList.get(i).distance;

            if(dsu.findUltimateParent(u)!=dsu.findUltimateParent(v))
            {
                cost+=wt;
                dsu.unionBySize(u,v);
            }
        }

        return cost;
    }

    public int minCostConnectPoints(int[][] points) {
        List<Triplet> adjList = new ArrayList<>();
        int n = points.length;
        prepareAdjacencyList(adjList, n , points);
        return createMinimumSpanningTree(adjList);
    }
}