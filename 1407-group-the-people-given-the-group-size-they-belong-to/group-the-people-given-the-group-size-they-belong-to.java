class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = groupSizes.length;
        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(groupSizes[i])) map.put(groupSizes[i],new ArrayList<>());
            map.get(groupSizes[i]).add(i);
        }

        for(Map.Entry<Integer,List<Integer>> i : map.entrySet())
        {
            List<Integer> indices = i.getValue();
            int key = i.getKey();
            for(int j=0;j<indices.size();)
            {
                List<Integer> temp  = new ArrayList<>();
                int count =0;
                while(count!=key)
                {
                    temp.add(indices.get(j));
                    j++;
                    count++;
                }
                 ans.add(new ArrayList<>(temp));
            }
        }

        return ans;
    }
}