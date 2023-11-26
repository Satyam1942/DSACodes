class Pair
{
    int time,freq;
    Pair(int time, int freq)
    {
        this.time = time;
        this.freq = freq;
    } 
}


class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<Pair> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int time = 0;

        int freq[] = new int[26];
        for(int i=0;i<tasks.length;i++)  freq[tasks[i]-65]++;
        for(int i=0;i<26;i++) if(freq[i]>0) pq.add(freq[i]);

        while(!q.isEmpty() || !pq.isEmpty())
        {
            time++;
            
            int curFreq = 0;
            if(!pq.isEmpty()) curFreq = pq.poll();
            while(!q.isEmpty() && q.peek().time<=time) pq.add(q.poll().freq);
            
          
          if(curFreq>1)q.add(new Pair(n+time,curFreq-1)); 
            
        }

        return time;

    }
}