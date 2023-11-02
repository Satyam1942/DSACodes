class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
     int length = nums.length;
    TreeMap<Integer,Integer> map1 = new  TreeMap<>();
    TreeMap<Integer,Integer> map2 = new TreeMap<>();

    int left = 0, right =0;
    int sizeMap1 =0 ,sizeMap2 =0;
    double median [] = new double[length-k+1];
    while(right<length)
    {
        if(map1.isEmpty() || nums[right]<=map1.lastKey() || 
        (!map2.isEmpty() && nums[right]<=map2.firstKey()))
        {
            map1.put(nums[right],map1.getOrDefault(nums[right],0)+1);
            sizeMap1++;
            if(sizeMap1>sizeMap2+1)
            {
                map2.put(map1.lastKey(),map2.getOrDefault(map1.lastKey(),0)+1);
                if(map1.get(map1.lastKey())==1)
                map1.remove(map1.lastKey());
                else map1.put(map1.lastKey(),map1.get(map1.lastKey())-1);
                sizeMap1--;
                sizeMap2++;
            }
        }   
        else 
        {
            map2.put(nums[right],map2.getOrDefault(nums[right],0)+1);
            sizeMap2++;
            if(sizeMap2>sizeMap1)
            {
            map1.put(map2.firstKey(),map1.getOrDefault(map2.firstKey(),0)+1);
               if(map2.get(map2.firstKey())==1)
                map2.remove(map2.firstKey());
                else map2.put(map2.firstKey(),map2.get(map2.firstKey())-1);
                sizeMap1++;
                sizeMap2--;
            }
        }
    //System.out.println(sizeMap1+" "+map1+" "+map2+" "+sizeMap2);
        if(right>=k-1)
        {
            if(k%2==0)
            {
            if(map2.isEmpty()) median[left] = (double)map1.lastKey();
            if(map1.isEmpty()) median[left] = (double) map2.firstKey();
            if(!map1.isEmpty() && !map2.isEmpty())
             median[left] = ((long)map1.lastKey()+(long)map2.firstKey())/2.0;
            }
            else median[left] = (double)map1.lastKey();

            int delKey = nums[left];
            if(map1.containsKey(delKey))
            {
                if(map1.get(delKey)==1) map1.remove(delKey);
                else map1.put(delKey,map1.get(delKey)-1);
                sizeMap1--;
            }
            else if(map2.containsKey(delKey))
            {
                if(map2.get(delKey)==1) map2.remove(delKey);
                else map2.put(delKey,map2.get(delKey)-1);
                sizeMap2--;
            }
            left++;
        }

        right++;
    }

        return median;
    }
}