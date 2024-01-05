class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxVal = values[0],maxIndex =0;
        int maxScore = 0;
        for(int i=1;i<values.length;i++)
        {
            int newVal = maxVal - (i-maxIndex);
            maxScore = Math.max(maxScore,newVal+values[i]);
            if(values[i]>=newVal) {maxVal = values[i]; maxIndex = i;}
        }
        return maxScore;
    }
}