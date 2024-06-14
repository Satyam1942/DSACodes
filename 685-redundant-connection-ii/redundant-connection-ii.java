class DisjointSet {
    List<Integer> parent;
    List<Integer> size;

    DisjointSet(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    int findUltimateParent(int u) {
        if (u == parent.get(u))
            return u;
        int ultimPar = findUltimateParent(parent.get(u));
        parent.set(u, ultimPar);
        return ultimPar;
    }

    void unionBySize(int u, int v) {
        int ultimParU = findUltimateParent(u);
        int ultimParV = findUltimateParent(v);

        if (ultimParU == ultimParV)
            return;

        if (size.get(ultimParU) >= size.get(ultimParV)) {
            parent.set(ultimParV, ultimParU);
            size.set(ultimParU, size.get(ultimParU) + size.get(ultimParV));
        } else {
            parent.set(ultimParU, ultimParV);
            size.set(ultimParV, size.get(ultimParU) + size.get(ultimParV));
        }
    }
}

class Solution {

    boolean isValid(int indegree[], int edges[][], int index) {
        int noOfNodes = indegree.length - 1;
        int freq[] = new int[2];
        
        for (int i = 1; i <= noOfNodes; i++) {
            if (indegree[i] > 1)
                return false;
            freq[indegree[i]]++;
        }
   
        if(freq[0]!=1)
            return false;

        DisjointSet ds = new DisjointSet(noOfNodes + 1);

        for (int i = 0; i < edges.length; i++) {
            if (index == i)
                continue;
            int u = ds.findUltimateParent(edges[i][0]);
            int v = ds.findUltimateParent(edges[i][1]);
            if (u == v)
                continue;
            else {
                ds.unionBySize(u, v);
            }
        }


        for(int i=1;i<noOfNodes;i++){
            int u = ds.findUltimateParent(i);
            int v = ds.findUltimateParent(i+1);
            if(u!=v)
                return false;

        }

        return true;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int noOfNodes = edges.length;
        int noOfEdges = edges.length;

        int indegree[] = new int[noOfNodes + 1];
        for (int i = 0; i < noOfEdges; i++) {
            indegree[edges[i][1]]++;
        }

        for (int i = noOfEdges - 1; i >= 0; i--) {
            indegree[edges[i][1]]--;
            if (isValid(indegree,edges,i))
                return edges[i];
            indegree[edges[i][1]]++;
        }

        return new int[2];
    }
}