class Solution {
    public int maxTwoEvents(int[][] events) {
        int length = events.length;
        int maxEventArr[] = new int[length];
        int maxValue = 0;

        Arrays.sort(events,(a,b)->(a[0]-b[0]));
        maxEventArr[length-1] = events[length-1][2];
        for(int i=length-2; i>=0; i--) {
            maxEventArr[i] = Math.max(events[i][2],maxEventArr[i+1]);
        }
        
        for(int i=0;i<length;i++) {
            int curVal = events[i][2];
            int curStart = events[i][0];
            int curEnd = events[i][1];
            //binary search segment
            int left = i+1;
            int right = length-1;
            int nextStartIndex = length;
            while(left<=right) {
                int  mid = (left+right)/2;
                if(events[mid][0]>curEnd) {
                    nextStartIndex = mid;
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }

            int nextVal = 0;
            if(nextStartIndex<length) {
                nextVal = maxEventArr[nextStartIndex];
            } 
            int totalVal = curVal+nextVal;
            maxValue = Math.max(maxValue, totalVal);
        }

        return maxValue;
    }
}