class MyCalendar {
    TreeMap<Integer,Integer> calender;
    public MyCalendar() {
        calender = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer floorVal = calender.floorKey(start);
        Integer ceilVal = calender.ceilingKey(start);

        if(ceilVal !=null && ceilVal<end)
            return false;
        if(floorVal!= null && calender.get(floorVal)>start)
            return false;
        
        calender.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */