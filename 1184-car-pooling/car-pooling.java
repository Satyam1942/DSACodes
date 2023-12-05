class Pair
{
    int end, noOfPassengers;
    Pair(int end, int noOfPassengers)
    {
        this.end = end;
        this.noOfPassengers = noOfPassengers;
    }
}

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->(a[1]-b[1]));

        int curCapacity = capacity;
        int pointer = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.end-b.end));

        while(pointer<trips.length)
        {
            int passengers = trips[pointer][0];
            int start = trips[pointer][1];
            int end = trips[pointer][2];

            while(!pq.isEmpty() && pq.peek().end<=start) curCapacity += pq.poll().noOfPassengers;

            if(curCapacity<passengers) return false;
            curCapacity-=passengers;
            pq.add(new Pair(end,passengers));

            pointer++;
        }

        return true;
        
    }
}

/*
    [1,5] ,[3,7] or [1,7], [3,5]
    [1,4], [5,6];

    [2,1,7],[2,3,5],[2,6,8]
    q=> (7,2)
 */