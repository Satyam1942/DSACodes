class Solution {
    void buildGraph(List<List<String>> tickets, HashMap<String, PriorityQueue<String>> adjList) {
        int numberOfTickets = tickets.size();
        for (int i = 0; i < numberOfTickets; i++) {
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);

            if (!adjList.containsKey(from))
                adjList.put(from, new PriorityQueue<>());
            adjList.get(from).add(to);
        }
    }

    void dfs(String curNode, HashMap<String,PriorityQueue<String>> adjList, Stack<String> reverseItinerary ){
     
        if(adjList.containsKey(curNode)){
            PriorityQueue<String> pq = adjList.get(curNode); 
            while(!pq.isEmpty()){
                String adjNode = pq.poll();
                dfs(adjNode,adjList,reverseItinerary);
            }
        }

        reverseItinerary.push(curNode);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adjList = new HashMap<>();
        buildGraph(tickets, adjList);

        Stack<String> reverseItinerary = new Stack<>();
        String startNode = "JFK";
        dfs(startNode, adjList, reverseItinerary);

        List<String> itinerary = new ArrayList<>();

        while (!reverseItinerary.isEmpty()) {
            itinerary.add(reverseItinerary.pop());
        }

        return itinerary;
    }
}