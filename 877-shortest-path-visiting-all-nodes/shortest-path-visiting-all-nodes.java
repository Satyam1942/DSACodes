class Solution {
    public int shortestPathLength(int[][] graph) {
        int numberOfNodes = graph.length;
        int rows = (1<<numberOfNodes);
        int cols = numberOfNodes;
        int dist[][] = new int[rows][cols];

        for(int i=0;i<rows;i++)
            Arrays.fill(dist[i],(int)(1e9));
        
        Queue<int[]>q = new LinkedList<>();
        for(int i=0;i<numberOfNodes;i++){
            int lead = i;
            int mask = 0^(1<<i);
            q.add(new int[]{lead,mask});
            dist[mask][lead] = 0;
        }

        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int curNode = q.peek()[0];
                int routeMask = q.peek()[1];
                q.poll();   
                if(routeMask==rows-1)
                    return dist[routeMask][curNode];

                for(int i=0;i<graph[curNode].length;i++){
                    int adjNode  = graph[curNode][i];
                    int adjRouteMask = routeMask|(1<<adjNode);
                   
                    if(dist[adjRouteMask][adjNode]>dist[routeMask][curNode]+1){
                        dist[adjRouteMask][adjNode] = dist[routeMask][curNode]+1;
                        q.add(new int[]{adjNode,adjRouteMask});
                    }
                }
            }
        }

        return  -1;

    }
}
/*
    SAME AS DJIKSTRA WE HAVE TO JUST MODIFY HOW WE PERCIEVE DISTANCE ARRAY
    SINCE NODES ARE LESS WE CAN MEMOIZE PATH Combination along with node Lead + MULTI SOURCE BFS
*/