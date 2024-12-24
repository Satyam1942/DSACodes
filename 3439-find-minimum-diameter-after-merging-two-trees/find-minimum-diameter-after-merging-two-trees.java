class Solution {
    int[] getDiameter(int edges[][]){
        int noOfNodes = edges.length+1;
        List<List<Integer>> adjList = new ArrayList<>();
        int noOfEdges = edges.length;
        int indegree[] = new int[noOfNodes];

        for(int i=0;i<noOfNodes;i++)
            adjList.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<noOfNodes;i++){
            if(indegree[i]==1)
                q.add(i);
        }
        
        int level = 0;
        int n = noOfNodes;
        while(n>2){
            int size = q.size();
            while(size-->0){
                int curNode = q.poll();
                for(int i=0;i<adjList.get(curNode).size();i++){
                    int adjNode = adjList.get(curNode).get(i);
                    indegree[adjNode]--;
                    if(indegree[adjNode]==1)
                        q.add(adjNode);
                }
                n--;
            }   
           level++;
        }

       if(q.size()==2){
           return new int[]{level,1};
       }else{
            return new int[]{level,0};
       }
      
    }
    
    
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int[] tree1Info = getDiameter(edges1);
        int[] tree2Info = getDiameter(edges2);
        int diameter1 = (tree1Info[1]==1)?2*tree1Info[0]+1:2*tree1Info[0];
        int diameter2 = (tree2Info[1]==1)?2*tree2Info[0]+1:2*tree2Info[0];
        int combinedDiameter = 1;
        if(tree1Info[1]==1){
            combinedDiameter+= tree1Info[0]+1;
        }else
            combinedDiameter+= tree1Info[0];
        
         if(tree2Info[1]==1){
            combinedDiameter+= tree2Info[0]+1;
        }else
            combinedDiameter+= tree2Info[0];
            
        return Math.max(diameter1, Math.max(diameter2, combinedDiameter));
    }   
}