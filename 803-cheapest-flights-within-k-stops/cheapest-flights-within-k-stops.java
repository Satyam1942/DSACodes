class Triplet {
    int node, price, stops;

    Triplet(int node, int price, int stops) {
        this.node = node;
        this.price = price;
        this.stops = stops;
    }
}

class Pair {
    int node, price;

    Pair(int node, int price) {
        this.node = node;
        this.price = price;
    }
}

class Solution {
    List<List<Pair>> buildGraph(int[][] flights, int n) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int price = flights[i][2];
            adjList.get(src).add(new Pair(dest, price));
        }

        return adjList;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adjList = buildGraph(flights, n);

        Queue<Triplet> q = new LinkedList<>();
        int price[] = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);

        q.add(new Triplet(src, 0, 0));
        price[src] = 0;

        while (!q.isEmpty()) {
            int curNode = q.peek().node;
            int curPrice = q.peek().price;
            int stopsTaken = q.peek().stops;
            q.poll();

            if (stopsTaken >= k + 1)
                continue;

            for (int index = 0; index < adjList.get(curNode).size(); index++) {
                int adjNode = adjList.get(curNode).get(index).node;
                int pathPrice = adjList.get(curNode).get(index).price;

                if (price[adjNode] > pathPrice + curPrice) {
                    price[adjNode] = pathPrice + curPrice;
                    q.add(new Triplet(adjNode, price[adjNode], stopsTaken + 1));
                }
            }

        }

        int cheapestPrice = price[dst];
        if (cheapestPrice == Integer.MAX_VALUE)
            return -1;
        return cheapestPrice;

    }
}