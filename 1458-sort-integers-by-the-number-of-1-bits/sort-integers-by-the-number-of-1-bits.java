class Solution {
    int getSetBits(int num)
    {
        int count = 0;
        for(int i=0;i<32;i++)
        {
            if((num&(1<<i))>0) count++;
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
        TreeMap<Integer,TreeSet<Integer>> map = new TreeMap<>();
        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int i=0;i<arr.length;i++)
        {
            int countSetBits = getSetBits(arr[i]);
            freq.put(arr[i], freq.getOrDefault(arr[i],0)+1);
            if(!map.containsKey(countSetBits)) map.put(countSetBits,new TreeSet<>());
            map.get(countSetBits).add(arr[i]);
        }

        int sortedArr[] = new int[arr.length];
        int pointer=0;
        for(Map.Entry<Integer,TreeSet<Integer>> i : map.entrySet())
        {
            TreeSet<Integer> set = i.getValue();
            for(int j:set)
            {
                int f = freq.get(j);
                while(f-->0){
                sortedArr[pointer] = j; 
                pointer++;
                }
            }
        }

        return sortedArr;
    }
}