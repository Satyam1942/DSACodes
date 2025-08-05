class Solution {
    boolean hasCycle(int n, int [][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n;i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u); 
        }

        for(int i=0; i<adjList.size(); i++) {
            if(adjList.get(i).size()!=2) {
                return false;
            }
        }

        return true;
    }

    public long maxScore(int n, int[][] edges) {
        long score = 0;
        score = (long)n*(long)(n-1);
        for(int i=n-1;i>0;i-=2) {
            if(i-2<0) {
                break;
            }
            score += (long)i*(long)(i-2);
        }

        score+= (long)n*(long)(n-2);
        for(int i=n-2; i>0; i-=2) {
            if(i-2<0) {
                break;
            }
            score += (long)i*(long)(i-2);
        }

        if(hasCycle(n, edges)) {
            return score+2l;
        } else {
            return score;
        }
    }
}