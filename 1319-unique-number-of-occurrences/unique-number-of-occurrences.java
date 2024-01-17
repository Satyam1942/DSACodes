class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
       HashSet<Integer> uniqueFreq = new HashSet<>();
        boolean flag = false;
        for(Map.Entry<Integer,Integer> i:map.entrySet()){
           if(!uniqueFreq.contains(i.getValue()))
                uniqueFreq.add(i.getValue());
            else return false;
        }

        return true;
    }
}