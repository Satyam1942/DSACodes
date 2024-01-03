class Pair
{
    int start,end;
    Pair(int start,int end)
    {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int visibleMountains(int[][] peaks) {
        int length = peaks.length;
        Pair base[] = new Pair[length];
        for(int i=0;i<length;i++)
        {
            int start = peaks[i][0]-peaks[i][1];
            int end = peaks[i][0]+peaks[i][1];
            base[i] = new Pair(start,end);
        }

        Arrays.sort(base,(a,b)->((a.start==b.start)?b.end-a.end:a.start-b.start));
        int count = (base.length>1 && base[0].start==base[1].start && base[0].end==base[1].end)?0:1;
        Pair prev = base[0];
        for(int i=1;i<length;i++)
        {
            Pair cur = base[i];
            if(cur.end<=prev.end) continue;
            prev.end = cur.end;
            if(i==peaks.length-1 || cur.start!=base[i+1].start || cur.end!=base[i+1].end) count++;
            
        }
        return count;
    }
}