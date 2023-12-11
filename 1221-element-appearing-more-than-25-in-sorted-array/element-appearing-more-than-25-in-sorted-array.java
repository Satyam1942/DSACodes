class Solution {
    public int findSpecialInteger(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
       
       int maxi = Integer.MIN_VALUE;
       int maxValue = -1;
       for(Map.Entry<Integer,Integer> i:map.entrySet())
       {
           if(maxi<i.getValue())
           {
           maxi = i.getValue();
           maxValue = i.getKey();
           }
       }

       return maxValue;
    }
}