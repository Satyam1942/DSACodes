class Pair implements Comparator<Pair>{
    int number;
    char type;
    Pair() {

    }

    Pair(int number, char type) {
        this.number = number;
        this.type = type;
    }

    @Override
    public int compare(Pair a, Pair b) {
        if(a.number==b.number) {
            return b.type-a.type;
        }
        else {
            return a.number - b.number;
        }
    }
}

class Solution {
    public int minGroups(int[][] intervals) {
        List<Pair> increasingOrderInterval = new ArrayList<>();
        int length = intervals.length;

        for(int i=0;i<length;i++) {
            increasingOrderInterval.add(new Pair(intervals[i][0],'S'));
            increasingOrderInterval.add(new Pair(intervals[i][1],'E'));
        }

        Collections.sort(increasingOrderInterval, new Pair());

        int count = 0;
        Stack<Character> st = new Stack<>();

        for(int i=0;i<increasingOrderInterval.size();i++) {
            char token = increasingOrderInterval.get(i).type;
            if(token=='S') {
                st.push('S');
            } else {
                if(!st.isEmpty()) {
                    st.pop();
                }
            }
            count = Math.max(count, st.size());
        }
        return  count;
    }
}


/*
    1,5
    1,10
    2,3
    5,10
    6,8

    (1,A,S), (1,B,S), (2,C,S), (3,C,E), (5,D,S), (5,A,E), (6,E,S), (8,E,E), (10,B,S), (10,D,E)
    onGoing = 1
    count =  1

*/