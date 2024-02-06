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

    int findUltimateParent(int node) {
        if (parent.get(node) == node)
            return node;

        int ultimPar = findUltimateParent(parent.get(node));
        parent.set(node, ultimPar);
        return ultimPar;
    }

    void unionBySize(int u, int v) {
        int parU = findUltimateParent(u);
        int parV = findUltimateParent(v);
        if (parU == parV)
            return;
        if (size.get(parU) < size.get(parV)) {
            parent.set(parU, parV);
            size.set(parV, size.get(parU) + size.get(parV));
        } else {
            parent.set(parV, parU);
            size.set(parU, size.get(parU) + size.get(parV));
        }
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet dsAlice = new DisjointSet(n+1);
        DisjointSet dsBob = new DisjointSet(n+1);
        
        Arrays.sort(edges,(a,b)->(b[0]-a[0]));

        int count = 0;
        int noOfEdgesAlice = 0;
        int noOfEdgesBob = 0;

        for(int i=0;i<edges.length;i++){

                int edgeType = edges[i][0];
                int u = edges[i][1];
                int v = edges[i][2];
                int parUAlice = dsAlice.findUltimateParent(u);
                int parVAlice = dsAlice.findUltimateParent(v);    
            
                int parUBob = dsBob.findUltimateParent(u);
                int parVBob = dsBob.findUltimateParent(v);  

                if(parUAlice==parVAlice && parUBob==parVBob) 
                    count++;
                else{  
                    if(edgeType==3){
                        noOfEdgesAlice++;
                        noOfEdgesBob++;
                        dsAlice.unionBySize(u,v);
                        dsBob.unionBySize(u,v);
                    }else if(edgeType==2){
                        if(parUBob==parVBob) count++;
                        else{ 
                            noOfEdgesBob++;
                            dsBob.unionBySize(u,v);
                        }
                    }
                    else {
                         if(parUAlice==parVAlice) count++;
                        else {
                            noOfEdgesAlice++;
                            dsAlice.unionBySize(u,v);
                        }    
                    }
                }
        }

        if(noOfEdgesAlice!=n-1 || noOfEdgesBob!=n-1)
            return -1;
            
        return count;
    }
}
