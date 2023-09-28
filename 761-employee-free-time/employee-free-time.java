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
class CustomComparator implements Comparator<Interval>
{
    public int compare(Interval a, Interval b)
    {
        if(a.start==b.start) return a.end - b.end;
        return a.start- b.start;
    }
}
class Solution {

    void buildIntervals(List<List<Interval>> schedule,List<Interval> intervals)
    {
        for(int i=0;i<schedule.size();i++)
        {
            for(int j=0;j<schedule.get(i).size();j++)
            {
                intervals.add(schedule.get(i).get(j));
            }
        }
    }

    void mergeIntervals(List<Interval> intervals,List<Interval> mergedIntervals)
    {
        for(int  i = 0;i<intervals.size();i++)
        {
            int curStart = intervals.get(i).start;
            int curEnd = intervals.get(i).end;
            int prevStart =(!mergedIntervals.isEmpty())?
            mergedIntervals.get(mergedIntervals.size()-1).start:0;
            int prevEnd = (!mergedIntervals.isEmpty())?
            mergedIntervals.get(mergedIntervals.size()-1).end:-1;

            if(mergedIntervals.isEmpty() ||curStart>prevEnd)
            {
                mergedIntervals.add(new Interval(curStart,curEnd));
            }
            else
            {
            mergedIntervals.set(mergedIntervals.size()-1,new Interval(prevStart,Math.max(prevEnd,curEnd)));
            }
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> intervals = new ArrayList<>();
        List<Interval> mergedIntervals = new ArrayList<>();
        List<Interval> freeTime = new ArrayList<>();

        //build Interval
        buildIntervals(schedule,intervals);
        Collections.sort(intervals,new CustomComparator());
        //merge interval
        mergeIntervals(intervals,mergedIntervals);
        //get free time
        for(int i=0;i<mergedIntervals.size()-1;i++)
        {
            int start = mergedIntervals.get(i).end;
            int end = mergedIntervals.get(i+1).start;
            freeTime.add(new Interval(start,end));
        }
        return freeTime;
    }
}