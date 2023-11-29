class Solution {
    public int maxEvents(int[][] events) {
       
        Arrays.sort(events,(a,b)->(a[0]-b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int minimumDay = Integer.MAX_VALUE, maximumDay = 0 ;
        for(int i=0;i<events.length;i++)
        {
         minimumDay = Math.min(minimumDay,events[i][0]);
         maximumDay = Math.max(maximumDay,events[i][1]);
        }
        
      
        int noOfEventsAttended = 0,pointer=0;
        for(int i=minimumDay;i<=maximumDay;i++)
        {
            while(!pq.isEmpty() && i>pq.peek()) pq.poll();
            while(pointer<events.length && i>=events[pointer][0]) {pq.add(events[pointer][1]); pointer++;}
            if(!pq.isEmpty())
            {
                noOfEventsAttended++;
                pq.poll();
            }
        }


        return noOfEventsAttended;
    }
}

/*
    [1,2], [2,4] , [1,4]
    ,,[1,5],[3,4] count=3  PQ: [1,5], [1,5]
    iterate from 1 to 5 
    at 1 => I will pick that job of 1 which has less end time   
    at 2=> [2,3]
    at 3 >[3,4]
    at 4=> there is no event left : so Now pop evnents from PQ which have already been finished
    Here there are no such events : so pop() : [1,5], and count++; no go for day 5 and do the same 

    1.Sort on basis of start time : if start times are same then on basis of end times
    2. Priority Queue : To store end time of event. If my current day>event end date poll all
    insert all events in PQ which have already started

 */