class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int length = times.length;
        HashMap<Integer,Integer> friendMap = new HashMap<>();
        TreeSet<Integer> seatsAvailable = new TreeSet<Integer>();
        int party[][] = new int[2*length][3];
        int maxSeatAvailable = -1;
        int j=0;

        for(int i=0;i<length;i++) {
            party[j][0] = times[i][0];
            party[j][1] = 0;
            party[j][2] = i;
            j++;
            party[j][0] = times[i][1];
            party[j][1] = 1;
            party[j][2] = i;
            j++;
        }        

        Arrays.sort(party,(a,b)->((a[0]==b[0])? b[1]-a[1]:a[0]-b[0]));
      
        for(int i=0;i<2*length;i++) {
            int friendNo = party[i][2];
            boolean hasArrived = party[i][1] == 0;
            if(hasArrived) { 
                int seatNo = (seatsAvailable.isEmpty()) ? ++maxSeatAvailable : seatsAvailable.first();
                seatsAvailable.remove(seatNo);
                friendMap.put(friendNo,seatNo);
                if(friendNo==targetFriend) {
                    return seatNo;
                }
            } else {
                int seatFree = friendMap.get(friendNo);
                friendMap.remove(friendNo);
                seatsAvailable.add(seatFree);
            }
        }

        return -1;

    }
}

/*
    (1,A,0); (2,A,1); (3,D,1); (4,D,0); (4,A,2); (6,D,2)
    int maxNum  = 1
    booked = 1
*/