class Solution {
    int dfs(int curNode, List<List<int[]>> adjList , int vis[])
{
	//marking node visited
	vis[curNode] = 1;

	int minimumWeight = Integer.MAX_VALUE;

	//iterating through all adjacent nodes
	for(int i=0;i<adjList.get(curNode).size();i++)
{
int adjNode = adjList.get(curNode).get(i)[0];
int weight = adjList.get(curNode).get(i)[1];

//taking minimum distance
minimumWeight = Math.min(minimumWeight,weight);

if(vis[adjNode]==0)
{
 	int tempWeight = dfs(adjNode,adjList,vis);
minimumWeight = Math.min(minimumWeight,tempWeight);
}
}

return minimumWeight;

}

    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adjList = new ArrayList<>();
	int vis[] = new int[n+1];

	for(int i=0;i<=n;i++) adjList.add(new ArrayList<>());

	for(int i=0;i<roads.length;i++)
	{
		int src = roads[i][0];
		int dest = roads[i][1];
		int dist = roads[i][2];

		int temp[] = new int[2];
		temp[0] = dest;
		temp[1] = dist;
	
	adjList.get(src).add(temp);

    int temp2[] = new int[2];
    temp2[0] = src;
    temp2[1] = dist;
    adjList.get(dest).add(temp2);
}

int minScore = dfs(1,adjList,vis);

return minScore;

    }
}