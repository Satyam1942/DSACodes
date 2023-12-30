class Solution {
    public int minMeetingRooms(int[][] meetingTimes) {
    int length = meetingTimes.length;
	Arrays.sort(meetingTimes,(a,b)->(a[0]-b[0]));
	PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	int noOfRooms = 0;
        for(int idx=0;idx<length;idx++)
        {
	        int startTime = meetingTimes[idx][0];
	        int endTime = meetingTimes[idx][1];
	        while(!pq.isEmpty() && pq.peek()<=startTime) pq.poll();
	        	pq.add(endTime);
	        noOfRooms = Math.max(noOfRooms,pq.size());
        }
	return noOfRooms;
    }
}