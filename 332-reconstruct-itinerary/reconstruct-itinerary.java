class Solution {
    void dfs(String node, HashMap<String,PriorityQueue<String>> adjList,Stack<String> itinerary)
    {
       
        if(adjList.get(node)!=null)
        {
        PriorityQueue<String> pq= adjList.get(node);
        while(!pq.isEmpty())
        {   
            String adjNode= pq.poll();
            dfs(adjNode,adjList,itinerary); 
        }
        }
        
        itinerary.add(node);
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        HashMap<String,PriorityQueue<String>> adjList = new HashMap<>();
        

        for(int i=0;i<tickets.size();i++)
        {
            String src = tickets.get(i).get(0);
            String dest = tickets.get(i).get(1);
            if(!adjList.containsKey(src)) adjList.put(src,new PriorityQueue<>());
            adjList.get(src).add(dest);
        }

        Stack<String> itinerary = new Stack<>();

        dfs("JFK",adjList,itinerary);

        List<String> ans = new ArrayList<>();
        while(!itinerary.isEmpty()) ans.add(itinerary.pop());

        return ans;


    }
}