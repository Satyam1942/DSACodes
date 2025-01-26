class Solution {
    int dfs(int node, int vis[], List<List<Integer>> adjList) {
        vis[node] = 1;
        int max = 0;
        for(int i=0; i<adjList.get(node).size(); i++) {
            int adjNode =  adjList.get(node).get(i);
            if(vis[adjNode]==0) {
                max = Math.max(max,dfs(adjNode, vis, adjList));
            }
        }
        return max+1;
    }

    public int maximumInvitations(int[] favorite) {
        int length = favorite.length;
        if(length==2) {
            return 2;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        List<List<Integer>> pairs = new ArrayList<>();

        for(int i=0;i<length;i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<length;i++) {
            int u = favorite[i];
            int v = i;
            if(v == favorite[u]) {
                if(u<v) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(v);
                    pair.add(u);
                    pairs.add(pair);
                }
            } else {
                adjList.get(u).add(v);
            }
        }

        int maxEmp = 0;
        int vis[] = new int[length];

        for(int i=0;i<pairs.size();i++) {
            maxEmp += dfs(pairs.get(i).get(0), vis, adjList) + dfs(pairs.get(i).get(1), vis, adjList);
        }

        int count[] = new int[length];
        int round[] = new int[length];
        int maxCycleLength = 0;
        int cycleNo = 1;

        for(int i=0;i<length;i++) {
            if(vis[i]==1) {
                continue;
            }
            if(round[i]!=0) {
                continue;
            }

            int cycleLength = 1;
            int  j = i;
            while(count[j]==0) {
                count[j] = cycleLength;
                round[j] = cycleNo;
                cycleLength++;
                j = favorite[j];
            }
            if(cycleNo == round[j]) {
                maxCycleLength = Math.max(maxCycleLength, cycleLength-count[j]);
            }
            cycleNo++;
        }

        return Math.max(maxCycleLength, maxEmp);
    }
}

/*

*/