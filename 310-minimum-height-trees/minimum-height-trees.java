class Solution {
    void buildTree(List<List<Integer>> adjList, int [][] edges, int n){
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
    }

    void calculateDegree(int [][] edges, int degree[]){
        for(int i=0;i<edges.length;i++){
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        int degree[] = new int[n];
        buildTree(adjList,edges,n);
        calculateDegree(edges,degree);
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1)
                q.add(i);
        }

        
        while(n>2){
            int size = q.size();
            while(size-->0){
                int curNode = q.poll();
                for(int i=0;i<adjList.get(curNode).size();i++){
                    int adjNode = adjList.get(curNode).get(i);
                    degree[adjNode]--;
                    if(degree[adjNode]==1){
                        q.add(adjNode);
                    }
                }
                n--;
            }
        }

        List<Integer> mhtRoot= new ArrayList<>();
        if(q.isEmpty()){
            mhtRoot.add(0);
        }

        while(!q.isEmpty())
            mhtRoot.add(q.poll());

        return mhtRoot;
    }
}