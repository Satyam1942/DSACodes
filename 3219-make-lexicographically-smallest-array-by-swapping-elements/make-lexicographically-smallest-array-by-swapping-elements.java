class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[][] sortedArray = new int[nums.length][2];
        TreeMap<Integer,TreeSet<Integer>> map = new TreeMap<>();

        for(int i=0;i<nums.length;i++)
        {
            sortedArray[i][0] = nums[i];
            sortedArray[i][1] = i;
        }

        Arrays.sort(sortedArray,(a,b)->(a[0]-b[0]));
        
        int curGroup = 0;
        map.put(curGroup, new TreeSet<>());
        map.get(curGroup).add(sortedArray[0][1]);

        for(int i=1;i<nums.length;i++)
        {
            if((sortedArray[i][0]-sortedArray[i-1][0])<=limit)
            {
                map.get(curGroup).add(sortedArray[i][1]);
            }
            else
            {
            curGroup++;
            map.put(curGroup,new TreeSet<>());
            map.get(curGroup).add(sortedArray[i][1]);
            }
        }
 
        int newArr[] = new int[nums.length];
        for(int i=0;i<sortedArray.length;)
        {
            for(Map.Entry<Integer,TreeSet<Integer>> j: map.entrySet())
            {
                TreeSet<Integer> set = j.getValue();
                for(int idx: set)
                {
                    newArr[idx] = sortedArray[i][0];
                    i++;
                }
            }
        }

        return newArr;
    }
}


/*
    1,5,3,9,8
    1,5,3 9,8
    1,3,5,8,9 

    1,3,5       8,9
    0->{0,1,2}

 */