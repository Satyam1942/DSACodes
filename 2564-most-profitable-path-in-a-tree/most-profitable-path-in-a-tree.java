class Solution {
    boolean findPathBob(int curNode, List<List<Integer>> adjList, int vis[], Stack<Integer> path) {
        vis[curNode] = 1;
        if (curNode == 0) {
            path.push(curNode);
            return true;
        }

        for (int i = 0; i < adjList.get(curNode).size(); i++) {
            int adjNode = adjList.get(curNode).get(i);
            if (vis[adjNode] == 0) {
                boolean res = findPathBob(adjNode, adjList, vis, path);
                if (res) {
                    path.push(curNode);
                    return true;
                }
            }
        }
        return false;
    }

    int findAliceIncome(int curNode, List<List<Integer>> adjList, int vis[], int amount[]) {
        vis[curNode] = 1;
        int maxAmt = Integer.MIN_VALUE;
        for(int i=0; i<adjList.get(curNode).size(); i++) {
            int adjNode = adjList.get(curNode).get(i);
            if(vis[adjNode]==0) {
                int res = findAliceIncome(adjNode, adjList, vis, amount);  
                maxAmt = Math.max(maxAmt, res);
            }
        }

        if(maxAmt == Integer.MIN_VALUE) {
            maxAmt = 0;
        }

        return  maxAmt+amount[curNode];
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int numberOfNodes = edges.length;
        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> pathBob = new ArrayList<>();
        Stack<Integer> pathBobStack = new Stack<>();
        int vis[] = new int[numberOfNodes + 1];

        for (int i = 0; i <= numberOfNodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < numberOfNodes; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        findPathBob(bob, adjList, vis, pathBobStack);

        while (!pathBobStack.isEmpty()) {
            pathBob.add(pathBobStack.pop());
        }
  
        int pathBobSize = pathBob.size();
        int center = pathBobSize / 2;
        for (int i = 0; i < center; i++) {
            int node = pathBob.get(i);
            amount[node] = 0;
        }
        if (pathBobSize % 2 != 0) {
            amount[pathBob.get(center)] = amount[pathBob.get(center)] / 2;
        }
       
        Arrays.fill(vis,0);
        int aliceIncome  = findAliceIncome(0, adjList, vis, amount);

        return aliceIncome;
    }
}

/*
 * 1. find the path from bob's node to root node; since its a tree => there will
 * always be a single path
 * 2. if no of nodes in path => odd => they meet => change amt to 0 till center
 * for center make it half
 * even => never meet => change amt to 0 till half
 * 3. perform dfs traversal for alice and return max amount;
 * 
 */