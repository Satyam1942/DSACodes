class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int numberOfNodes = nums.length;
        List<HashSet<Integer>> adjList = new ArrayList<>();
        List<Integer> toposort = new ArrayList<>();

        for(int i=0;i<=numberOfNodes;i++)
            adjList.add(new HashSet<>());

        for(int i=0;i<sequences.size();i++){
            for(int j=0;j<sequences.get(i).size()-1;j++){
                int  u = sequences.get(i).get(j);
                int  v = sequences.get(i).get(j+1);
                adjList.get(u).add(v);
            }
        } 

        int indegree[] = new int[numberOfNodes+1];
        for(int i=1;i<=numberOfNodes;i++){
            HashSet<Integer> set = adjList.get(i);
            for(int node:set)
                indegree[node]++;
        }      

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=numberOfNodes;i++){
            if(indegree[i]==0){
                q.add(i);
                toposort.add(i);
            }        
        }

        if(q.size()>1)
            return false;

        while(!q.isEmpty()){
            int curNode = q.poll();
            int count = 0;
            HashSet<Integer> set  = adjList.get(curNode);
            for(int adjNode:set){
                indegree[adjNode]--;
                if(indegree[adjNode]==0){
                    toposort.add(adjNode);
                    count++;
                    q.add(adjNode);
                }
                if(count>1)
                    return false;
            }
        }

        if(toposort.size()!=numberOfNodes)
            return false;

        for(int i=0;i<numberOfNodes;i++){
            if(nums[i]!=toposort.get(i))
                return false;
        }

        return true;
    }
}