class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int length = colors.length;
        int noOfQueries = queries.length;
        HashMap<Integer, TreeSet<Integer>> mapIndices = new HashMap<>();
        List<Integer> shortestDistance = new ArrayList<>();

        // nlogn mapping colors and indices
        for (int idx = 0; idx < length; idx++) {
            int curColor = colors[idx];
            if (!mapIndices.containsKey(curColor))
                mapIndices.put(curColor, new TreeSet<>());
            mapIndices.get(curColor).add(idx);
        }
        // answering all queries
        for (int idx = 0; idx < noOfQueries; idx++) {
            int targetIndex = queries[idx][0];
            int targetColor = queries[idx][1];
            Integer floorIndex = (mapIndices.containsKey(targetColor)) ? 
                                mapIndices.get(targetColor).floor(targetIndex): null;
            Integer ceilingIndex = (mapIndices.containsKey(targetColor))? 
                                    mapIndices.get(targetColor).ceiling(targetIndex): null;

            if (floorIndex == null && ceilingIndex == null)
                shortestDistance.add(-1);
            else if (floorIndex == null)
                shortestDistance.add(ceilingIndex - targetIndex);
            else if (ceilingIndex == null)
                shortestDistance.add(targetIndex - floorIndex);
            else
                shortestDistance.add(Math.min(targetIndex - floorIndex, ceilingIndex - targetIndex));
        }

        return shortestDistance;

    }
}