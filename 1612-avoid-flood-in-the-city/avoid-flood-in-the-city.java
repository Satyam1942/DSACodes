class Solution {
    public int[] avoidFlood(int[] rains) {
        int noOfLakes = rains.length;
        int pumpLake[] = new int[noOfLakes];
        TreeSet<Integer> zeroIndex = new TreeSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<noOfLakes;i++){
            int waterLevel = rains[i];
            if(waterLevel==0){
                zeroIndex.add(i);
            }else{
                if(map.containsKey(waterLevel)){
                    int prevIndex = map.get(waterLevel);
                    Integer index = zeroIndex.ceiling(prevIndex);
                    if(index!=null){
                        pumpLake[index] = waterLevel;
                        zeroIndex.remove(index);
                        map.remove(waterLevel);
                    }else
                        return new int[0];
                }

                map.put(waterLevel,i);
                pumpLake[i] = -1;
            }
        }

        for(int ind: zeroIndex)
            pumpLake[ind] = 1;

        return pumpLake;
    }
}

/*
    I want to find  value that will come in future first and that has come in past
    1       
    2
*/ 