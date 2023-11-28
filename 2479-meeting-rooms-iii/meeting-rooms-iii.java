class Pair
{
    int start,end,roomNo;
    Pair(int start, int end,int roomNo)
    {
        this.start = start;
        this.end = end;
        this.roomNo = roomNo;
    }
}

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int noOfMeetings = meetings.length;
        Arrays.sort(meetings,(a,b)->(a[0]-b[0]));

    int meetingNo[] = new int[n];
   PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->((a.end==b.end)?(a.roomNo-b.roomNo):a.end-b.end));
   PriorityQueue<Integer>  freeRoom = new PriorityQueue<>();
   for(int i=0;i<n;i++) freeRoom.add(i);

    pq.add(new Pair(meetings[0][0],meetings[0][1],0));
    freeRoom.poll();
    meetingNo[0]++;

    for(int i=1;i<meetings.length;i++)
    {
       int curRoom = pq.peek().roomNo;
       int prevStart = pq.peek().start;
       int prevEnd = pq.peek().end;
       int curStart = meetings[i][0];
       int curEnd = meetings[i][1];
       
       if(prevEnd>curStart)
       {
           if(freeRoom.isEmpty())
           {
               pq.poll();
            int newStart = prevEnd;
            int newEnd = newStart+(curEnd-curStart);
            pq.add(new Pair(newStart,newEnd,curRoom));
            meetingNo[curRoom]++;
           }
           else
           {
           int newRoom = freeRoom.poll();
           meetingNo[newRoom]++;
           pq.add(new Pair(curStart,curEnd,newRoom));
           }
       }
       else
       {
   
           while(!pq.isEmpty() && pq.peek().end<=curStart)
           { 
               freeRoom.add(pq.peek().roomNo);
               pq.poll();
           }
          
           int newRoom = (!freeRoom.isEmpty())?freeRoom.poll():curRoom;
           meetingNo[newRoom]++;
           pq.add(new Pair(curStart,curEnd,newRoom)); 
       }

    }

    int maxi = 0, maxMeetingRoom = -1;
    for(int i=0;i<n;i++)
    {
        if(meetingNo[i]>maxi) {maxi = meetingNo[i]; maxMeetingRoom = i;}
    }

    return maxMeetingRoom;
    }
}

/*
    0 1
    PriorityQueue for rooms
    PriorityQueue for meeting Times = startTimes

    0     [0,10]       [1,1]
    1     [1,5]         (0,10)
          [5,10]        (1,5)
          [10,11]

        [0,10]
        [1,5]

        0-1
        1-2
          Step1 : Schedule the meetings
  */