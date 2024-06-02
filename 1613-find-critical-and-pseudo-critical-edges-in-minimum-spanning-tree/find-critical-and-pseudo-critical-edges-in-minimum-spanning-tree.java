class DisjointSet{

    List<Integer> parent;
    List<Integer> size;

    DisjointSet(int n){
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUltimateParent(int node){
        if(parent.get(node)==node)
            return node;
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node,ultimateParent);
        return ultimateParent;
    }

    public void unionBySize(int u, int v){
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);
        if(ultimateParentU == ultimateParentV)
            return;

        if(size.get(ultimateParentU)>=size.get(ultimateParentV)){
            parent.set(ultimateParentV,ultimateParentU);
            size.set(ultimateParentU, size.get(ultimateParentV)+size.get(ultimateParentU));
        }else{
            parent.set(ultimateParentU,ultimateParentV);
            size.set(ultimateParentV, size.get(ultimateParentV)+size.get(ultimateParentU));
        }
    }
}

class Solution {
    int getMinimumSpanningTreeWeight(int edges[][] , int pick, int skip, int n){
        int sumWt = 0;
        int numberOfEdges = edges.length;
        DisjointSet ds = new DisjointSet(n);

        if(pick!=-1){
            ds.unionBySize(edges[pick][0],edges[pick][1]);
            sumWt+=edges[pick][2];
        }

        for(int i=0;i<numberOfEdges;i++){
            if(skip==i)
                continue;
            int  u = edges[i][0];
            int  v = edges[i][1];
            int weight = edges[i][2];
            if(ds.findUltimateParent(u)!=ds.findUltimateParent(v)){
                ds.unionBySize(u,v);
                sumWt+=weight;
            } 
        }

        for(int i=0;i<n;i++) {
            if(ds.findUltimateParent(i)!=ds.findUltimateParent(0)) 
                return Integer.MAX_VALUE;
        }

        return sumWt;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        int numberOfEdges = edges.length;
        int modifiedEdges[][] = new int[numberOfEdges][4];

        for(int i=0;i<numberOfEdges;i++){
            modifiedEdges[i][0] = edges[i][0];
            modifiedEdges[i][1] = edges[i][1];
            modifiedEdges[i][2] = edges[i][2];
            modifiedEdges[i][3] = i;
        }

        Arrays.sort(modifiedEdges,(a,b)->(a[2]-b[2]));

        int minimumSpanningTreeWeight = getMinimumSpanningTreeWeight(modifiedEdges,-1,-1,n);

        List<Integer> criticalEdges= new ArrayList<>();
        List<Integer> pseudoCriticalEdges = new ArrayList<>();

        for(int i=0;i<numberOfEdges;i++){
            int currentMinimumSpanningTreeWeight = getMinimumSpanningTreeWeight(modifiedEdges,-1, i ,n);
            if(minimumSpanningTreeWeight<currentMinimumSpanningTreeWeight){
                criticalEdges.add(modifiedEdges[i][3]);
            }else{
                int newMinimumSpanningTreeWeight = getMinimumSpanningTreeWeight(modifiedEdges,i, -1 ,n);
                if(newMinimumSpanningTreeWeight==minimumSpanningTreeWeight)
                    pseudoCriticalEdges.add(modifiedEdges[i][3]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(criticalEdges));
        ans.add(new ArrayList<>(pseudoCriticalEdges));
        return ans;

    }
}

/*
  DO WHAT IS SAID DONT THINK MUCH!
 */