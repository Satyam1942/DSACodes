class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        Arrays.sort(flowers,(a,b)->(a[0]-b[0]));
        int newPeople[] = new int[people.length];
        for(int i=0;i<people.length;i++) newPeople[i] = people[i];
        Arrays.sort(people);

        int ans[] = new int[people.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int flowerIndex = 0;
        for(int i=0;i<people.length;i++)
        {
            int curTime = people[i];

            while(flowerIndex<flowers.length && flowers[flowerIndex][0]<=curTime)
            {
                pq.add(flowers[flowerIndex][1]);
                flowerIndex++;
            }
        
            while(!pq.isEmpty() && pq.peek()<curTime)
            {
               pq.poll();
            }

            map.put(curTime,pq.size());
        }
        
        for(int i=0;i<people.length;i++) ans[i] = map.get(newPeople[i]);

        return ans;
    }
}