class Pair implements Comparator<Pair>{
    double ratio;
    int quality;
    Pair(){

    }
    Pair(double ratio, int quality){
        this.ratio = ratio;
        this.quality = quality;
    }
    @Override
    public int compare(Pair a, Pair b){
        return Double.compare(a.ratio,b.ratio);
    }
}

class CustomComparator implements Comparator<Pair>{
    @Override
    public int compare(Pair a, Pair b){
        return b.quality-a.quality;
    }
}

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int noOfWorkers = quality.length;
        Pair ratio[] = new Pair[noOfWorkers];
        for(int i=0;i<noOfWorkers;i++){
            double tempRatio = wage[i]/(double)quality[i];
            ratio[i] = new Pair(tempRatio,quality[i]);
        }

        Arrays.sort(ratio,new Pair());
        PriorityQueue<Pair> pq = new PriorityQueue(new CustomComparator());

        double minCost = Integer.MAX_VALUE;
        double sumOfQuality = 0;
        for(int i=0;i<noOfWorkers;i++){
            pq.add(ratio[i]);
            sumOfQuality+=ratio[i].quality;

            if(pq.size()>k)
                sumOfQuality -=pq.poll().quality;

            if(pq.size()==k){
                double tempCost = sumOfQuality*ratio[i].ratio;
                minCost = Math.min(minCost,tempCost);
            }
        }

        return minCost;
    }
}