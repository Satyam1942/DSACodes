class Solution {
    void dfs(HashMap<String,PriorityQueue<String>> adjList,String src, Stack<String> stack )
    {

        PriorityQueue<String> neighbourPQ =  adjList.get(src);
        while(neighbourPQ!=null && !neighbourPQ.isEmpty())
        {
            dfs(adjList,neighbourPQ.poll(),stack);
        }
        stack.push(src);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> adjList = new HashMap<>();
        List<String> validItinerary = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        int noOfTickets = tickets.size();
        
        for(int i=0;i<noOfTickets;i++)
        {
            String src = tickets.get(i).get(0);
            String dst = tickets.get(i).get(1);
            if(!adjList.containsKey(src))adjList.put(src,new PriorityQueue<>());
            adjList.get(src).add(dst);
        }

        String src = "JFK";
        dfs(adjList,src,stack);

        while(!stack.isEmpty())
        {
            validItinerary.add(stack.pop());
        }

        return validItinerary;
    }
}