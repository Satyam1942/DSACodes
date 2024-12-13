class Solution {
    public long findScore(int[] nums) {
        int length = nums.length;
        int sortedNums[][] = new int[length][2];
        for(int i=0;i<length;i++) {
            sortedNums[i][0] = nums[i];
            sortedNums[i][1] = i;
        }
        Arrays.sort(sortedNums,(a,b)->(a[0]==b[0])?a[1]-b[1] :a[0]-b[0]);

        long score = 0;
        HashSet<Integer> markedIndices = new HashSet<>();
        for(int i = 0;i<length;i++) {
            int index = sortedNums[i][1];
            int num = sortedNums[i][0];
            if(markedIndices.contains(index)) {
                continue;
            }
            score+=num;
            markedIndices.add(index+1);
            markedIndices.add(index-1);
        }
        return score;
    }

}