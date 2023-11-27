class DisjointSet
{
    List<Integer> parent;
    List<Integer> size;
    DisjointSet(int n)
    {
        parent=  new ArrayList<>();
        size = new ArrayList<>();
        for(int i=0;i<n;i++) {parent.add(i); size.add(1);}
    }

    int findUltimateParent(int node)
    {
        if(parent.get(node)==node) return node;
        int ultmParent = findUltimateParent(parent.get(node));
        parent.set(node,ultmParent);
        return ultmParent;
    }

    void unionBySize(int u, int v)
    {
        int ultimU = findUltimateParent(u);
        int ultimV = findUltimateParent(v);

        if(ultimU==ultimV) return;
        if(size.get(ultimU)>size.get(ultimV))
        {
            parent.set(ultimV,ultimU);
            size.set(ultimU, size.get(ultimU)+size.get(ultimV));
        }
        else
        {
            parent.set(ultimU,ultimV);
            size.set(ultimV, size.get(ultimU)+size.get(ultimV));
        }
    }
}


class Solution {
    void fillIndegree(int [][] edges , int indegree[])
    {
        for(int i=0;i<edges.length;i++)
        {
            indegree[edges[i][1]]++;
        }
    }


    public int[] findRedundantDirectedConnection(int[][] edges) {
        int numberOfNodes = edges.length;
        int indegree[] = new int[numberOfNodes+1];

        fillIndegree(edges,indegree);

        boolean isType2 = false;
        for(int i=0;i<=numberOfNodes;i++)
        {
            if(indegree[i]==2) {isType2 = true; break;}
        }

        DisjointSet ds = new DisjointSet(numberOfNodes+1);

      
        if(!isType2)
        {
        for(int i=0;i<edges.length;i++)
        {
            if(ds.findUltimateParent(edges[i][0])!=ds.findUltimateParent(edges[i][1]))
            {
                ds.unionBySize(edges[i][0],edges[i][1]);
            }
            else 
            {
                int ans[] = new int[2];
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
                return ans;
            }
        }
        }
        else 
        {
       
            int cycleIndex= -1 ;
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==2) {cycleIndex = i; break;}
        }

        int edge1 = -1, edge2 = -1;
        for(int i=0;i<edges.length;i++)
        {
            if(edges[i][1]==cycleIndex)
            {
                if(edge1==-1) edge1 = i;
                else edge2 = i;
            }
        }   

        boolean hasCycle = false;
         for(int i=0;i<edges.length;i++)
        {
            if(i==edge2) continue;

            if(ds.findUltimateParent(edges[i][0])!=ds.findUltimateParent(edges[i][1]))
            {
                ds.unionBySize(edges[i][0],edges[i][1]);
            }
            else 
            {
                hasCycle = true;
                break;
            }
        }

        if(hasCycle) return edges[edge1];
        else return edges[edge2];
        }

        return new int[2];
}
}
/*
    
    case 1:
    all indegree = 1
    case 2: 1 indegree= 0 (root) and 1 node indegree = 2
    case2.1 : Has cycle , 2.2 has no cycle
    Using DSU remove each edge and check if graph is connected

 */