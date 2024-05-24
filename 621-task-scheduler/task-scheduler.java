class Pair implements Comparator<Pair>{
    char task;
    int count;
    Pair(){

    }
    Pair(char task, int count){
        this.task = task;
        this.count = count;
    }

    @Override
    public int compare(Pair a, Pair b){
        return b.count-a.count;
    }
}

class Triplet{
    char task;
    int count;
    int time;
    Triplet(char task, int count, int time){
        this.task = task;
        this.count =count;
        this.time = time;
    }
}


class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        int noOfTasks = tasks.length;
        for(int i=0;i<noOfTasks;i++){
            char token = tasks[i];
            freq[(int)token-65]++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Pair());
        Queue<Triplet> q = new LinkedList<>();

        for(int i=0;i<26;i++){
            if(freq[i]==0)
                continue;
            char token = (char)(i+65);
            pq.add(new Pair(token,freq[i]));
        }

        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            while(!q.isEmpty() && q.peek().time<time){
                char task  = q.peek().task;
                int count = q.peek().count;
                q.poll();
                pq.add(new Pair(task,count));
            }

            if(!pq.isEmpty()){
                char task = pq.peek().task;
                int  count = pq.peek().count;
                pq.poll();
                if(count>1){
                    int newTime = n+time;
                    q.add(new Triplet(task,count-1,newTime));
                }
            }

            time++;
        }

        return time;
    }
}