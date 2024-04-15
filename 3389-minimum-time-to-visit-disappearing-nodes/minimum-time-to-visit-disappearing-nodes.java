class Pair {
    int node;
    int time;

    Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }
}

class Tuple implements Comparator<Tuple> {
    int node;
    int time;

    Tuple() {
    }

    Tuple(int node, int time) {
        this.node = node;
        this.time = time;
    }

    @Override
    public int compare(Tuple a, Tuple b) {
        return a.time - b.time;
    }
}

class Solution {
    void buildGraph(List<List<Tuple>> adjList,int numberOfNodes, int [][] edges ){
        int numberOfEdges = edges.length;
	    for(int i=0;i<numberOfNodes; i++)
		    adjList.add(new ArrayList<>());


	    for(int i=0;i<numberOfEdges;i++){
		    adjList.get(edges[i][0]).add(new Tuple(edges[i][1],edges[i][2]));
		    adjList.get(edges[i][1]).add(new Tuple(edges[i][0],edges[i][2]));
        }
    }

    public int[] minimumTime(int numberOfNodes, int[][] edges, int disappear[]) {
        List<List<Tuple>> adjList = new ArrayList<>();

        buildGraph(adjList, numberOfNodes, edges);

        PriorityQueue<Tuple> pq = new PriorityQueue<>(new Tuple());

        int distance[] = new int[numberOfNodes];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[0] = 0;
        pq.add(new Tuple(0, 0));

        boolean visited[] = new boolean[numberOfNodes];
        while (!pq.isEmpty()) {

            int curNode = pq.peek().node;
            int timeTaken = pq.peek().time;
            pq.poll();
            if(visited[curNode])
                continue;
            visited[curNode] = true;
            
            for (int i = 0; i < adjList.get(curNode).size(); i++) {

                int adjNode = adjList.get(curNode).get(i).node;
                int additionalTime = adjList.get(curNode).get(i).time;
                int newTime = timeTaken + additionalTime;

                boolean isValid = distance[adjNode] > newTime && newTime < disappear[adjNode];

                if (isValid) {
                    distance[adjNode] = newTime;
                    pq.add(new Tuple(adjNode, newTime));
                }
                
            }
        }

        for (int i = 0; i < numberOfNodes; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                distance[i] = -1;
        }

        return distance;
    }
}