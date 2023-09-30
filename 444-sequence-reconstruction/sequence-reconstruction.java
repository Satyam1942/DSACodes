class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int length = nums.length;
        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> topoSort = new ArrayList<>();
        int indegree[] = new int[length+1];
        for(int i=0;i<=length;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<sequences.size();i++)
        {
            for(int j=1;j<sequences.get(i).size();j++)
            {
                adjList.get(sequences.get(i).get(j-1)).add(sequences.get(i).get(j));
                indegree[sequences.get(i).get(j)]++;
            }
        }

        //Check if it hads unique toposort

        Queue<Integer> q = new LinkedList<>();
        int vis[] = new int[length+1];
        
        for(int i=1;i<=length;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
                vis[i]=1;
                topoSort.add(i);
            }
        }
        
        if(q.isEmpty()|| q.size()>1) return false;

        while(!q.isEmpty())
        {
            int curNode=  q.poll();
              int count = 0;
            for(int i=0;i<adjList.get(curNode).size();i++)
            {
                int adjNode = adjList.get(curNode).get(i);
                if(vis[adjNode]==0)
                {
                    indegree[adjNode]--;
                    if(indegree[adjNode]==0)
                    {
                        vis[adjNode]=1;
                        q.add(adjNode);
                        topoSort.add(adjNode);
                        count++;
                    }
                }
                if(count>1) return false;
            }
        }
        
        for(int i=0;i<length;i++)
        {
            if(nums[i]!=topoSort.get(i)) return false;
        }

        return true;
    }
}