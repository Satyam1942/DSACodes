class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int length = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
   
      
        int prev = heights[0];
        for(int i=1;i<length;i++){
            int dif = heights[i]-prev;
            if(dif>0){
                pq.add(dif);
                if(pq.size()>ladders){
                    bricks-=pq.poll();
                    if(bricks<0)
                        return i-1;
                }
            
            }
            prev = heights[i];
        }

        return length-1;
    }
}

/*
    [4,2,7,6,9,14,12]
     [-,5,-,3,5,-]
     3 ladders or 13 bricks

     [2,3,2,4,100]  bricks = 4, ladder =1
     [(1,1),0,(2,3),(96,4)]
     1-1
     2-3
     96-4

     [2,3,2,98,100]
     [(1,1),0,(96,3),(2,4)]
     
     [4,12,2,7,3,18,20,3,19]
     [8,0,5,0,15,2,0,16]]
     [2,5,8,15,16]
     [2,7]

 */