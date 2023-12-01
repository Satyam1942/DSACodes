class Solution {

    int getFloorIndex(List<Integer> sorted, int height)
    {
        int left = 0;
        int right = sorted.size()-1;
        int maxIndex = right;
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(sorted.get(mid)>=height) {right = mid-1; maxIndex= mid;}
            else left = mid+1;
        }

        return maxIndex;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->((a[0]==b[0])?b[1]-a[1]:a[0]-b[0]));
        List<Integer> sorted = new ArrayList<>();
        //find Longest Increasing Subsequence wrt height using  Binary Search

        sorted.add(envelopes[0][1]);
        for(int i=1;i<envelopes.length;i++)
        {
            int height = envelopes[i][1];
            if(height>sorted.get(sorted.size()-1)) sorted.add(height);
            else
            {
                int index = getFloorIndex(sorted,height);
                sorted.set(index,height);
            }
        }
        
        return sorted.size();

    }
}