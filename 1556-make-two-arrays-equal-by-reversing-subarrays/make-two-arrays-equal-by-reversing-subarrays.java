class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer> targetFreq = new HashMap<>();
        HashMap<Integer,Integer> arrFreq = new HashMap<>();
        int length = arr.length;

        for(int i=0;i<length;i++){
            int val = target[i];
            int freq =  targetFreq.getOrDefault(val,0);
            targetFreq.put(val,freq+1);
        }

         for(int i=0;i<length;i++){
            int val = arr[i];
            int freq =  arrFreq.getOrDefault(val,0);
            arrFreq.put(val,freq+1);
        }

        if(arrFreq.size()!=targetFreq.size())
            return false;
            
        for(Map.Entry<Integer,Integer> i: targetFreq.entrySet()){
            if(!arrFreq.containsKey(i.getKey()) || i.getValue()!=arrFreq.get(i.getKey()))
                return false;
        }

        return true;
    }
}