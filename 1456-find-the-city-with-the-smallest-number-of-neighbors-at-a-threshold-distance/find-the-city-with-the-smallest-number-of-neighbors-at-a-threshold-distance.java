class Solution {
    void getDistance(int distanceMatrix[][], int edges[][]) {
        int numberOfEdges = edges.length;
        int numberOfNodes = distanceMatrix.length;

        for (int row[] : distanceMatrix)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int node = 0; node < numberOfNodes; node++)
            distanceMatrix[node][node] = 0;

        for (int index = 0; index < numberOfEdges; index++) {
            int u = edges[index][0];
            int v = edges[index][1];
            int weight = edges[index][2];
            distanceMatrix[u][v] = weight;
            distanceMatrix[v][u] = weight;
        }

        for (int via = 0; via < numberOfNodes; via++) {
            for (int src = 0; src < numberOfNodes; src++) {
                for (int dest = 0; dest < numberOfNodes; dest++) {
                    if (distanceMatrix[src][via] == Integer.MAX_VALUE ||
                            distanceMatrix[via][dest] == Integer.MAX_VALUE)
                        continue;

                    distanceMatrix[src][dest] = Math.min(distanceMatrix[src][dest],
                            distanceMatrix[src][via] + distanceMatrix[via][dest]);

                }
            }
        }
    }

    void getNeighbourCount(int countOfNeighbors[], int numberOfNodes, int distanceMatrix[][], int thresholdDistance) {
        for (int src = 0; src < numberOfNodes; src++) {
            for (int dest = src + 1; dest < numberOfNodes; dest++) {
                int dist = distanceMatrix[src][dest];
                if (dist <= thresholdDistance) {
                    countOfNeighbors[dest]++;
                    countOfNeighbors[src]++;
                }

            }
        }
    }

    public int findTheCity(int numberOfNodes, int[][] edges, int distanceThreshold) {
        int numberOfEdges = edges.length;
        int distanceMatrix[][] = new int[numberOfNodes][numberOfNodes];
        getDistance(distanceMatrix, edges);

        int countOfNeighbors[] = new int[numberOfNodes];
        getNeighbourCount(countOfNeighbors, numberOfNodes, distanceMatrix,distanceThreshold);

        int minNeighbors = numberOfNodes;
        int nodeWithMinNeighbors = 0;
        for (int node = 0; node < numberOfNodes; node++) {
            int neighborCount = countOfNeighbors[node];
            if (neighborCount <= minNeighbors) {
                minNeighbors = neighborCount;
                nodeWithMinNeighbors = node;
            }
        }

        return nodeWithMinNeighbors;

    }
}