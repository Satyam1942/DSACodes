class Pair {
    int end, room;

    Pair(int end, int room) {
        this.room = room;
        this.end = end;
    }
}

class CustomComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        if (a.end == b.end)
            return a.room - b.room;
        else
            return a.end - b.end;
    }
}

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<int[]> meetingTimes = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<Pair> scheduled = new PriorityQueue<>(new CustomComparator());
        PriorityQueue<Integer> freeRoom = new PriorityQueue<>();

        int noOfMeetingsAssigned[] = new int[n];
        int noOfMeetings = meetings.length;
        for (int i = 0; i < noOfMeetings; i++)
            meetingTimes.add(meetings[i]);

        for (int i = 0; i < n; i++)
            freeRoom.add(i);

        while (!meetingTimes.isEmpty()) {
            int curStart = meetingTimes.peek()[0];
            int curEnd = meetingTimes.peek()[1];
            meetingTimes.poll();
            int prevEnd = (!scheduled.isEmpty()) ? scheduled.peek().end : 0;

            if (freeRoom.isEmpty()) {

                if (curStart >= prevEnd) {
                    while (!scheduled.isEmpty() && curStart >= scheduled.peek().end)
                        freeRoom.add(scheduled.poll().room);

                    int roomNo = freeRoom.poll();
                    scheduled.add(new Pair(curEnd, roomNo));
                    noOfMeetingsAssigned[roomNo]++;
                } else {
                    int roomNo = scheduled.poll().room;
                    int newEnd = prevEnd+(curEnd-curStart);
                    scheduled.add(new Pair(newEnd, roomNo));
                    noOfMeetingsAssigned[roomNo]++;
                }

            } else {

                while (!scheduled.isEmpty() && curStart >= scheduled.peek().end)
                    freeRoom.add(scheduled.poll().room);
                int roomNo = freeRoom.poll();
                scheduled.add(new Pair(curEnd, roomNo));
                noOfMeetingsAssigned[roomNo]++;
            }
        }

        int maxMeetings = 0, maxRoom = 0;
        for (int roomNo = 0; roomNo < n; roomNo++) {
            if (maxMeetings < noOfMeetingsAssigned[roomNo]) {
                maxMeetings = noOfMeetingsAssigned[roomNo];
                maxRoom = roomNo;
            }
        }

        return maxRoom;
    }
}