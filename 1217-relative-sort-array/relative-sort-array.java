class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int lengthOfArray1 = arr1.length;
        int lengthOfArray2 = arr2.length;

        for(int i=0;i<lengthOfArray1;i++){
            int val = arr1[i];
            int freq = map.getOrDefault(val,0);
            map.put(val,freq+1);
        }

        int sortedArray[] = new int[lengthOfArray1];
        int pointer = 0;
        for(int i=0;i<lengthOfArray2;i++){
            int freq = map.get(arr2[i]);
            while(freq-->0){
                sortedArray[pointer++] = arr2[i];
            }
            map.remove(arr2[i]);
        }

        for(Map.Entry<Integer,Integer> i: map.entrySet()){
            int val = i.getKey();
            int freq = i.getValue();
            while(freq-->0)
                sortedArray[pointer++] = val;
        }

        return sortedArray;
    }
}