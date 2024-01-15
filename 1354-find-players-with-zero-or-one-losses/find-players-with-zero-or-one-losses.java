class Solution {
    void buildGraph(HashMap<Integer,List<Integer>> adjList,int[][] matches){
        for(int i=0;i<matches.length;i++){
            if(!adjList.containsKey(matches[i][0]))
                adjList.put(matches[i][0],new ArrayList<>());
            adjList.get(matches[i][0]).add(matches[i][1]);
        }
    }

    void calcIndegree(HashMap<Integer,List<Integer>> adjList,
                    HashMap<Integer,Integer> indegree, int[][] matches){

        for(int i=0;i<matches.length;i++){
            indegree.put(matches[i][0],0);
            indegree.put(matches[i][1],0);
        }

        for(Map.Entry<Integer,List<Integer>> i:adjList.entrySet()){
            List<Integer> neighbor = i.getValue();
            for(Integer node:neighbor){
                int curIndegree = indegree.get(node);
                indegree.put(node,curIndegree+1);
            }
        }
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        //build a graph
        //answer[0] = all nodes with indegree 0
        //answer[1] = all nodes with indegree 1

        HashMap<Integer,List<Integer>> adjList = new HashMap<>();
        HashMap<Integer,Integer> indegree =  new HashMap<>();
        List<List<Integer>> answer = new ArrayList<>();

        buildGraph(adjList,matches);
        calcIndegree(adjList,indegree,matches);

        for(int i=0;i<2;i++) 
            answer.add(new ArrayList<>());

        for(Map.Entry<Integer,Integer> i: indegree.entrySet()){
            if(i.getValue()==0)
                answer.get(0).add(i.getKey());
            else if(i.getValue()==1)
                answer.get(1).add(i.getKey());
        }

        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));
        
        return answer;
    }
}
/*
1->{3}
2->{3}
3->{6}
5->{6,7}
4->{5,8,9}
10->{4,9}
 */