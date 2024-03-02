class Solution {
    public int[] avoidFlood(int[] rains) {

        int noOfLakes = rains.length;
        int ans[] = new int[noOfLakes];

        HashMap<Integer,Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        int anyLake = 0;

        for(int i =0;i<noOfLakes;i++){

            if(rains[i]==0)
                set.add(i);
            else{
                ans[i] = -1;
                anyLake = rains[i];

                if(map.containsKey(rains[i])){
                    if(!set.isEmpty() && set.ceiling(map.get(rains[i]))!=null){
                        ans[set.ceiling(map.get(rains[i]))] = rains[i];
                        set.remove(set.ceiling(map.get(rains[i])));
                    }else
                        return new int[0];
                }

                map.put(rains[i],i);
            }
        }

        for(int i=0;i<noOfLakes;i++){
            if(ans[i]==0){
                ans[i] = anyLake;
            }
        }

        return ans; 
    }
}