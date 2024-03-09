class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->(a[0]-b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // will store finish time

        int numberOfEvents =  events.length;
        int minTime = 0, maxTime =0;

        for(int i=0;i<numberOfEvents;i++){
            minTime= Math.min(minTime,events[i][0]);
            maxTime = Math.max(maxTime,events[i][1]);
        }

        int index = 0;
        int count = 0;
        
        for(int time=minTime;time<=maxTime;time++){
            //remove unattended already finished events
            while(!pq.isEmpty() && pq.peek()<time){
                pq.poll();
            }

            //add all available events that you can attend
            while(index<numberOfEvents && events[index][0]<=time){
                pq.add(events[index][1]);
                index++;
            }

            //attend the optimal event
            if(!pq.isEmpty()){
                count++;
                pq.poll();
            }
        }
        return count;
    }
}
