class Pair
{
    int val, time;
    Pair(int val , int time)
    {
        this.val =val;
        this.time= time;
    } 
}

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adjList = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.time-b.time));
        int indegree[] = new int[n+1];
        for(int i=0;i<=n;i++) adjList.add(new ArrayList<>());

        for(int i=0;i<relations.length;i++)
        {
            adjList.get(relations[i][0]).add(relations[i][1]);
            indegree[relations[i][1]]++;
        }

        for(int i=1;i<=n;i++)
        {
            if(indegree[i]==0) 
            {
                pq.add(new Pair(i,time[i-1]));
            }
        }

        int noOfMonths=0;
        while(!pq.isEmpty())
        {
            int course = pq.peek().val;
            int curTime = pq.peek().time;
             pq.poll();

            noOfMonths= Math.max(noOfMonths,curTime);
           
            for(int i=0;i<adjList.get(course).size();i++)
            {
                int adjCourse = adjList.get(course).get(i);
                indegree[adjCourse]--;
                if(indegree[adjCourse]==0)
                {
                    pq.add(new Pair(adjCourse,time[adjCourse-1]+curTime));
                }
            }
        }

        return noOfMonths;

        


    }
}