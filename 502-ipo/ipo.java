class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int length = profits.length;
        int projectDetails[][] = new int[length][2];
        for(int i=0;i<length;i++){
            projectDetails[i][0] = profits[i];
            projectDetails[i][1] = capital[i];
        }

        Arrays.sort(projectDetails,(a,b)->(a[1]-b[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int pointer = 0;

        while(k-->0){
            while(pointer<length && projectDetails[pointer][1]<=w){
                pq.add(projectDetails[pointer][0]);
                pointer++;
            }
            if(!pq.isEmpty()){
                w+=pq.poll();
            }
        }

        return w;
    }
}

/*
    1 2 3
    0 1 1 
    TreeMap/TreeSet/PriorityQueue
        4   3
        1   1    
    1-> 3,2

*/