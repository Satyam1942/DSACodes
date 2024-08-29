class Solution {
    void dfs( List<List<Integer>> adjList, int[] vis, int node)
    {
        vis[node]=1;
         for(int adjNode: adjList.get(node))
         {
             if(vis[adjNode]==0) dfs(adjList, vis,adjNode);
         }
    }
    public int removeStones(int[][] stones) {
        int noOfStones = stones.length;
       List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<noOfStones;i++) adjList.add(new ArrayList<>());

        for(int i=0;i<noOfStones;i++) {
            for(int j=0;j<noOfStones;j++) { 
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]) {
                     adjList.get(i).add(j);
                     adjList.get(j).add(i);
                }
            }
        }

        int vis[] = new int[noOfStones];
        int noOfComponents=0;
        for(int i=0;i<noOfStones;i++) {
            if(vis[i]==0) {
                dfs(adjList,vis,i); 
                noOfComponents++;
            }
        }

        return noOfStones- noOfComponents;
    }
}