class Triplet {
    char task;
    int count;
    int time;

    Triplet(char task, int time, int count) {
        this.task = task;
        this.time = time;
        this.count = count;
    }
}

class Pair {
    char task;
    int count;

    Pair(char task, int count) {
        this.task = task;
        this.count = count;
    }
}

class CustomComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return b.count - a.count;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(new CustomComparator());
        Queue<Triplet> q = new LinkedList<>();
        int freq[] = new int[26];

        for (int i = 0; i < tasks.length; i++) {
            char curTask = tasks[i];
            freq[(int) curTask - 65]++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                continue;

            char curTask = (char) (i + 65);
            pq.add(new Pair(curTask, freq[i]));
        }
        
        int time = 0;
        while (!q.isEmpty() || !pq.isEmpty()) {

            while (!q.isEmpty() && q.peek().time < time) {
                char task = q.peek().task;
                int count = q.peek().count;
                q.poll();
                pq.add(new Pair(task, count));
            }

            if (!pq.isEmpty()) {
                char task = pq.peek().task;
                int curFreq = pq.peek().count;
                pq.poll();

                if (curFreq != 1)
                    q.add(new Triplet(task,time+n, curFreq - 1));
            }

            time++;
        }

        return time;
    }
}