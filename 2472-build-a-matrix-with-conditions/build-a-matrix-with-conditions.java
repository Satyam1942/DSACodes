class Solution {
    void buildGraph(List<List<Integer>> adjList, int[][] conditions ,int k){
        int noOfEdges = conditions.length;
        for(int i=0;i<=k;i++)
            adjList.add(new ArrayList<>());

        for(int i=0;i<noOfEdges;i++){
            int u = conditions[i][1];
            int v = conditions[i][0];
            adjList.get(u).add(v);
        }
    }

    boolean getTopoSort(List<List<Integer>> adjList,  List<Integer> topoSort, int k){
        int indegree[] = new int[k+1];
        for(int i=1;i<=k;i++){
            for(int j=0;j<adjList.get(i).size();j++)
                indegree[adjList.get(i).get(j)]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=k;i++){
            if(indegree[i]==0){
                q.add(i);
                topoSort.add(i);
            }
        }

        while(!q.isEmpty()){
            int curNode = q.poll();
            for(int i=0;i<adjList.get(curNode).size();i++){
                int adjNode = adjList.get(curNode).get(i);
                indegree[adjNode]--;
                if(indegree[adjNode]==0){
                    topoSort.add(adjNode);
                    q.add(adjNode);
                }
            }
        }

        return topoSort.size()==k;

    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<List<Integer>> adjListRow = new ArrayList<>();
        List<List<Integer>> adjListCol = new ArrayList<>();
        List<Integer> rowTopoSort = new ArrayList<>();
        List<Integer> colTopoSort = new ArrayList<>();
        

        buildGraph(adjListRow,rowConditions,k);
        buildGraph(adjListCol,colConditions,k);

        boolean isRowTopoSort = getTopoSort(adjListRow,rowTopoSort,k);
        boolean isColTopoSort = getTopoSort(adjListCol,colTopoSort,k);

        if(!isRowTopoSort || !isColTopoSort)
            return new int[0][0];

        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=1;i<=k;i++)
            map.put(i,new ArrayList<>());

        for(int i=0;i<k;i++){
            int node = rowTopoSort.get(i);
            map.get(node).add(k-i-1);
        }

        for(int i=0;i<k;i++){
            int node = colTopoSort.get(i);
            map.get(node).add(k-i-1);
        }

        int matrix[][] = new int[k][k];

        for(Map.Entry<Integer,List<Integer>> i: map.entrySet()){
            int key = i.getKey();
            List<Integer> coordinates = i.getValue();
            matrix[coordinates.get(0)][coordinates.get(1)] = key;
        }

        return matrix;
    }
}