class DisjointSet {
    List<Integer> parent;
    List<Integer> size;

    DisjointSet(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i=0; i<n; i++) {
            parent.add(i);
            size.add(0);
        }
    }


    int findUltimateParent(int u) {
        if(parent.get(u) == u) {
            return u;
        }

        int ultimPar = findUltimateParent(parent.get(u));
        parent.set(u, ultimPar);
        return ultimPar;
    }


    void unionBySize(int u, int v) {
        int ultimParU = findUltimateParent(u);
        int ultimParV = findUltimateParent(v);

        if(ultimParU == ultimParV) {
            return;
        }

        if(size.get(ultimParU)>size.get(ultimParV)) {
            parent.set(ultimParV, ultimParU);
            size.set(ultimParU, size.get(ultimParU)+size.get(ultimParV));
        } else {
            parent.set(ultimParU, ultimParV);
            size.set(ultimParU, size.get(ultimParU)+size.get(ultimParV));
        }
    }
}

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int length = edgeList.length;
        int queryLength = queries.length;
        boolean ans[] = new boolean[queryLength];
        int modifiedQueries[][] = new int[queryLength][4];

        for(int i=0; i<queries.length; i++) {
            modifiedQueries[i][0] = queries[i][0];
            modifiedQueries[i][1] = queries[i][1];
            modifiedQueries[i][2] = queries[i][2];
            modifiedQueries[i][3] = i;
        }

        Arrays.sort(modifiedQueries, (a,b)->(a[2]-b[2]));
        Arrays.sort(edgeList, (a,b)->(a[2]-b[2]));
        
        DisjointSet dsu = new DisjointSet(n);

        int j = 0;
        for(int i=0; i<queryLength; i++) {
            while(j<length && edgeList[j][2]<modifiedQueries[i][2]) {
                int u = edgeList[j][0];
                int v = edgeList[j][1];
                dsu.unionBySize(u, v);
                j++;
            }
            int u = modifiedQueries[i][0];
            int v = modifiedQueries[i][1];
            int index = modifiedQueries[i][3];
            if(dsu.findUltimateParent(u) == dsu.findUltimateParent(v)) {
                ans[index] = true;
            }
        }

        return ans;
    }
}