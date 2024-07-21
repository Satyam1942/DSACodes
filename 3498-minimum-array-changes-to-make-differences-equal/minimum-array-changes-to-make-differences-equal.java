class Pair implements Comparator<Pair>{
    int element;
    int freq;
    Pair(){

    }

    Pair(int element, int freq){
        this.element = element;
        this.freq = freq;
    }

    @Override
    public int compare(Pair a, Pair b){
        if(a.freq==b.freq)
            return a.element-b.element;
        else
            return b.freq - a.freq;
    }
}

class Solution {
    public int minChanges(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Pair());
        int length =  nums.length;

        for(int i=0;i<length/2;i++){
            int element = Math.abs(nums[i]-nums[length-i-1]);
            int freq = map.getOrDefault(element,0);
            map.put(element,freq+1);
        }

        for(Map.Entry<Integer,Integer> i: map.entrySet()){
            pq.add(new Pair(i.getKey(),i.getValue()));
        }

        int dif1 = pq.poll().element;
        int noOfChanges1 = 0;
        for(int i =0;i<length/2;i++){
            int element = Math.abs(nums[i]-nums[length-i-1]);
            if(dif1==element)
                continue;

            int mini = Math.min(nums[i],nums[length-i-1]);
            int maxi = Math.max(nums[i],nums[length-i-1]);
            if(mini+dif1<=k || maxi-dif1>=0){
                noOfChanges1++;
            }else
                noOfChanges1+=2;
        }

        if(pq.isEmpty())
            return noOfChanges1;

        int dif2 = pq.poll().element;
        int noOfChanges2 = 0;
        for(int i =0;i<length/2;i++){
            int element = Math.abs(nums[i]-nums[length-i-1]);
            if(dif2==element)
                continue;

            int mini = Math.min(nums[i],nums[length-i-1]);
            int maxi = Math.max(nums[i],nums[length-i-1]);
            if(mini+dif2<=k || maxi-dif2>=0){
                noOfChanges2++;
            }else
                noOfChanges2+=2;
        }

        return Math.min(noOfChanges1,noOfChanges2);
    }
}