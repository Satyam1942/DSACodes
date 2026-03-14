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
        if (u == parent.get(u)) {
            return u;
        }
        int ultimPar = findUltimateParent(parent.get(u));
        parent.set(u, ultimPar);
        return ultimPar;
    }

    void unionBySize(int u, int v) {
        int ultimParU = findUltimateParent(u);
        int ultimParV = findUltimateParent(v);

        if (size.get(ultimParU) > size.get(ultimParV)) {
            size.set(ultimParU, size.get(ultimParV) + size.get(ultimParU));
            parent.set(ultimParV, ultimParU);
        } else {
            size.set(ultimParV, size.get(ultimParV) + size.get(ultimParU));
            parent.set(ultimParU, ultimParV);
        }
    }
}

class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        DisjointSet ds = new DisjointSet(n);
        List<int[]> notMustEdges = new ArrayList<>();
        int maxStability = Integer.MAX_VALUE;

        if (n == 0) {
            return 0;
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int stability = edges[i][2];
            int isMust = edges[i][3];
            if (isMust == 1) {
                int ultimParU = ds.findUltimateParent(u);
                int ultimParV = ds.findUltimateParent(v);
                if (ultimParU == ultimParV) {
                    return -1;
                } else {
                    ds.unionBySize(u, v);
                    maxStability = Math.min(maxStability, stability);
                }
            } else {
                notMustEdges.add(new int[] { u, v, stability });
            }
        }

        Collections.sort(notMustEdges, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[2] - a[2];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < notMustEdges.size(); i++) {
            int u = notMustEdges.get(i)[0];
            int v = notMustEdges.get(i)[1];
            int stability = notMustEdges.get(i)[2];
            int ultimParU = ds.findUltimateParent(u);
            int ultimParV = ds.findUltimateParent(v);
            if (ultimParU != ultimParV) {
                ds.unionBySize(u, v);
                pq.add(stability);
            }
        }

        // more than one components
        for (int i = 0; i < n - 1; i++) {
            if (ds.findUltimateParent(i) != ds.findUltimateParent(i + 1)) {
                return -1;
            }
        }

        while (!pq.isEmpty()) {
            int minStability = (k-- > 0) ? 2 * pq.poll() : pq.poll();
            maxStability = Math.min(maxStability, minStability);
        }

        return maxStability;
    }
}