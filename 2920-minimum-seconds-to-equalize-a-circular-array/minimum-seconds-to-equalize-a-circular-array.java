class Solution {
    public int minimumSeconds(List<Integer> nums) {
        HashMap<Integer,List<Integer>> freq = new HashMap<>();
        int length = nums.size();
        for(int i=0;i<length;i++){
            int val = nums.get(i);
            if(!freq.containsKey(val))
                freq.put(val,new ArrayList<>());

            freq.get(val).add(i);
        }
        
        int minTime = Integer.MAX_VALUE;
        for(Map.Entry<Integer,List<Integer>> i: freq.entrySet()){
            int val = i.getKey();
            List<Integer> indices = i.getValue();
            int maxGap = length-(indices.get(indices.size()-1)-indices.get(0));
            for(int j=0;j<indices.size()-1;j++){
                int gap = indices.get(j+1)-indices.get(j);
                maxGap = Math.max(maxGap,gap);
            }
            minTime = Math.min(minTime,maxGap/2);
        }
        return minTime;
    }
}