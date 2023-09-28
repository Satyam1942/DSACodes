class Solution {
    public int minMeetingRooms(int[][] intervals) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        int maxMeetingRooms = 0;
        for(int i=0;i<intervals.length;i++)
        {
            while(!pq.isEmpty() && pq.peek()<=intervals[i][0])
            {
                pq.poll();
            }
            pq.add(intervals[i][1]);
            maxMeetingRooms = Math.max(maxMeetingRooms,pq.size());
        }
        return maxMeetingRooms;
    }
}