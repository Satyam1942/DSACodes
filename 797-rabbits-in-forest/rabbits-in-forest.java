class Solution {
    public int numRabbits(int[] answers) {
        int length = answers.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<length; i++) {
            int groupNo = answers[i];
            if(map.containsKey(groupNo)) {
                int freq = map.get(groupNo);
                if(freq == 1) {
                    map.remove(groupNo);
                } else {
                    map.put(groupNo, freq-1);
                }
            } else {
                if(groupNo!=0) {
                    map.put(groupNo, groupNo);
                }
                count+=groupNo+1;
            }
        }
        
        return count;
    }
}
/*
    1,  1,  2`
    10-

    2 
    2

*/