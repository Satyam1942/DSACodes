class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int length = nums.length;
        int i = 0, j = 0;
        int count = 0;
        TreeSet<Integer> rangeIndex = new TreeSet<>();
        HashMap<Integer,Integer> freq = new HashMap<>();

        while(i<=j && j<=length){
            if(freq.size()>k){
                rangeIndex.add(j-2);
                int f = freq.get(nums[i]);
                if(f==1)
                    freq.remove(nums[i]);
                else
                    freq.put(nums[i],f-1);
                i++;
                continue;
            }

            if(j<length){
                freq.put(nums[j],freq.getOrDefault(nums[j],0)+1);
            }
            j++;
        }

        if(freq.size()==k)
            rangeIndex.add(length-1);

        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> firstIndex = new HashMap<>();
        i=0;
        j=0;
        while(j<=length){
            if(map.size()==k){
                firstIndex.put(i,j-1);
                int f = map.get(nums[i]);
                if(f==1)
                    map.remove(nums[i]);
                else
                    map.put(nums[i],f-1);
                i++;
                continue;
            }
            if(j<length)
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            j++;
        }
        // System.out.println(firstIndex);

        for(Map.Entry<Integer,Integer> itr:firstIndex.entrySet()){
            int index = itr.getValue();
            Integer key = rangeIndex.ceiling(index);
            if(key!=null)
                count+= (key-index+1);
        }

        return count;

    }
}

/*
   
   1-1

   1,2,1,2,3
   1-1
   2-1

   j=> 3,4
   i=>
   0-1
   1-2
   2-3
   3-4

    1,2,1,3,4
    j=> 3,4
    i=>
    0-3
    1-3
    2-4

 */