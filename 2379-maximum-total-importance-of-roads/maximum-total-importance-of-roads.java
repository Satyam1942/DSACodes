class Solution {
    public long maximumImportance(int noOfCities, int[][] roads) {
        int numberOfRoads = roads.length;
        int indegree[][] = new int[noOfCities][2];

        for(int i=0;i<noOfCities;i++){
            indegree[i][1] = i;
        }

        for (int i = 0; i < numberOfRoads; i++) {
            indegree[roads[i][1]][0]++;
            indegree[roads[i][0]][0]++;
        }

        Arrays.sort(indegree, (a, b) -> (b[0] - a[0]));

        int valOfNodes[] = new int[noOfCities];
        int val = noOfCities;
    
        for (int i = 0; i < noOfCities; i++) {
            int city = indegree[i][1];
            valOfNodes[city] = val;
            val--;
        }

        long maxImportance = 0;
        for (int i = 0; i < numberOfRoads; i++) {
            int cityA = roads[i][0];
            int cityB = roads[i][1];
            maxImportance += (long) valOfNodes[cityA] + (long) valOfNodes[cityB];
        }

        return maxImportance;

    }
}