/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval>  pq = new PriorityQueue<>((a,b)->(a.start-b.start));
        List<Interval> freeTime = new ArrayList<>();
        for(int i=0;i<schedule.size();i++)
        {
            for(int j=0;j<schedule.get(i).size();j++)
            {
                pq.add(schedule.get(i).get(j));
            }
        }

        Interval prev = pq.poll();
        while(!pq.isEmpty())
        {
            Interval next = pq.poll();
            if(next.start>prev.end) {freeTime.add(new Interval(prev.end,next.start)); prev.end = next.end;}
            else prev.end = Math.max(next.end,prev.end);
        }
        return freeTime;
    }
}