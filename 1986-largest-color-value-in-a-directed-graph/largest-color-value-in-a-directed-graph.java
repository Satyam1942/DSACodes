class Solution {

    int dfs(int curNode, int vis[], int pathVis[], String colors, List<List<Integer>> adjList, int cache[][]) {
        vis[curNode] = 1;
        pathVis[curNode] = 1;

        int curColor = (int)colors.charAt(curNode)-97;
        cache[curNode][curColor]+=1;
        int maxAdjColor[] = new int[26];

        for(int i=0;i<adjList.get(curNode).size();i++){
            int adjNode = adjList.get(curNode).get(i);

            if(vis[adjNode]==0)
                dfs(adjNode,vis,pathVis,colors,adjList,cache);
            else if(pathVis[adjNode]==1){
                Arrays.fill(cache[curNode],Integer.MAX_VALUE);   
                return Integer.MAX_VALUE;
            }

            for(int j=0;j<26;j++){
               maxAdjColor[j] = Math.max(maxAdjColor[j],cache[adjNode][j]);
            }
        }

        for(int i=0;i<26;i++){
            if(maxAdjColor[i]==Integer.MAX_VALUE)
                cache[curNode][i] = Integer.MAX_VALUE;
            else
                cache[curNode][i] += maxAdjColor[i];
        }

        int maxColor = 0;
        for(int i=0;i<26;i++)
            maxColor = Math.max(maxColor, cache[curNode][i]);

        cache[curNode][26]  = maxColor;
        pathVis[curNode] = 0;

        return maxColor;
    }

    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        int noOfEdges = edges.length;
        int noOfNodes = colors.length();
        int indegree[] = new int[noOfNodes];

        for(int i =0;i<noOfNodes;i++)
            adjList.add(new ArrayList<>());

        for(int i=0;i<noOfEdges;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
        }

        int vis[] = new int[noOfNodes];
        int pathVis[] = new int[noOfNodes];
        int cache[][] = new int[noOfNodes][27];

        int maxVal = -1;
        for(int i=0;i<noOfNodes;i++){
            if(vis[i]==0){
                dfs(i, vis, pathVis, colors, adjList, cache);
                maxVal = Math.max(maxVal,cache[i][26]);
            }
        }

        if(maxVal==Integer.MAX_VALUE)
            return -1;
        else
            return maxVal;

    }
}