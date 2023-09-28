class DisjointSet
{
    List<Integer> parent;
    List<Integer> size;
    DisjointSet(int n)
    {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }

    int findUltimateParent(int node)
    {
        if(parent.get(node)==node) return node;
        int ultParent = findUltimateParent(parent.get(node));
        parent.set(node,ultParent);
        return ultParent;
    }

    void unionBySize(int u ,int v)
    {
        int ultU =  findUltimateParent(u);
        int ultV = findUltimateParent(v);
        if(ultU==ultV) return ;

        if(size.get(ultU)<size.get(ultV))
        {
            parent.set(ultU,ultV);
            size.set(ultV, size.get(ultU)+size.get(ultV));
        }
        else
        {
           parent.set(ultV,ultU);
          size.set(ultU, size.get(ultU)+size.get(ultV));   
        }
    }
}

class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs,(a,b)->(a[0]-b[0]));
        DisjointSet ds = new DisjointSet(n);

        int minTime = 0;
        for(int i=0;i<logs.length;i++)
        {
            int time = logs[i][0];
            int u = logs[i][1];
            int v = logs[i][2];
            if(ds.findUltimateParent(u)!=ds.findUltimateParent(v))
            {
                ds.unionBySize(u,v);
                minTime = time;
            }
        }
        
        for(int i=1;i<n;i++)
        {
            if(ds.findUltimateParent(i)!=ds.findUltimateParent(0)) return -1;
        }

        return minTime;
    }
}