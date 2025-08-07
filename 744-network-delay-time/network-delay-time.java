class Solution {
    int[] getTime(int source, List<List<int[]>> adjList) {
        int noOfNodes = adjList.size();
        int time[] = new int[noOfNodes];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        Arrays.fill(time, Integer.MAX_VALUE);
        q.add(new int[] {source, 0});
        time[source] = 0;

        while(!q.isEmpty()) {
            int node = q.peek()[0];
            int curTime = q.peek()[1];
            q.poll();
            for(int i=0; i<adjList.get(node).size(); i++) {
                int adjNode = adjList.get(node).get(i)[0];
                int adjWeight = adjList.get(node).get(i)[1];
                int newTime = curTime+adjWeight;
                if(time[adjNode]>newTime) {
                    time[adjNode] = newTime;
                    q.add(new int[] {adjNode, newTime});
                }
            }
        }
        return time;
    }

    void buildGraph(int[][] times, int n, List<List<int[]>> adjList) {
        for(int i=0;i<=n;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int time = times[i][2];
            adjList.get(u).add(new int[]{v, time});
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        buildGraph(times, n, adjList);
        int time[] = getTime(k, adjList);
        int minTime = Integer.MIN_VALUE;
        for(int i=1; i<=n;i++) {
            minTime = Math.max(minTime, time[i]);
        }
        if(minTime == Integer.MAX_VALUE) {
            return -1;
        }
        return minTime;
    }
}