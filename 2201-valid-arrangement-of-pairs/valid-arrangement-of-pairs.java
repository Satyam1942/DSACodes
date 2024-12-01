class Solution {
    void dfs (int node, HashMap<Integer,Queue<Integer>> adjList, Stack<Integer> path) {
        Queue<Integer> q = adjList.get(node);
        if(q!=null) {
            while(!q.isEmpty()) {
                int adjNode = q.poll();
                dfs(adjNode, adjList, path);
            }
        }
        path.push(node);
    }

    void buildGraph(HashMap<Integer, Queue<Integer>> adjList, int pairs[][]) {
        int length = pairs.length;
        for(int i=0;i<length;i++) {
            int u = pairs[i][0];
            int v = pairs[i][1];
            if(!adjList.containsKey(u)) {
                adjList.put(u,new LinkedList<>());
            }
            adjList.get(u).add(v);
        }
    }

    void calculateIndegree(HashMap<Integer,Integer> indegree, int pairs[][]) {
        int length = pairs.length;
        for(int i=0;i<length;i++) {
            int v = pairs[i][1];
            int curCount = indegree.getOrDefault(v,0);
            indegree.put(v,curCount+1);
        }
    }
    void calculateOutdegree(HashMap<Integer,Integer> outdegree, int pairs[][]) {
        int length = pairs.length;
        for(int i=0;i<length;i++) {
            int u = pairs[i][0];
            int curCount = outdegree.getOrDefault(u,0);
            outdegree.put(u,curCount+1);
        }
    }

    int getStartNode(HashMap<Integer,Integer> indegree, HashMap<Integer,Integer> outdegree) {
        for(Map.Entry<Integer,Integer> i: outdegree.entrySet()) {
            int node = i.getKey();
            int indeg = indegree.getOrDefault(node,0);
            if(indeg<outdegree.get(node)) {
                return node;
            }
        }

        for(Map.Entry<Integer,Integer> i: outdegree.entrySet()) {
            int node = i.getKey();
            int val = i.getValue();
            if(val>0) {
                return node;
            }
        }
        return -1;
    }

    public int[][] validArrangement(int[][] pairs) {
        int noOfPairs = pairs.length;
        Stack<Integer> path = new Stack<>(); 
        HashMap<Integer,Queue<Integer>> adjList = new HashMap<>();
        HashMap<Integer,Integer> outdegree = new HashMap<>();
        HashMap<Integer,Integer> indegree = new HashMap<>();
        
        buildGraph(adjList, pairs);
        calculateIndegree(indegree, pairs);
        calculateOutdegree(outdegree, pairs);
        int startNode = getStartNode(indegree, outdegree);

        dfs(startNode, adjList, path);

        int arrangement[][] = new int[noOfPairs][2];
        int i = 0;

        int node1 = path.pop();
        while(!path.isEmpty()){
            int node2 = path.pop();
            arrangement[i][0] = node1;
            arrangement[i][1] = node2;
            node1 = node2;
            i++;
        }

        return arrangement;
    }
}