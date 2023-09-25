class CustomComparator implements Comparator<int[]>
{
    public int compare(int[] a, int []b)
    {
        if(a[0]==b[0]) return b[1]-a[1];
        else  return a[0] - b[0];
    }
}

class Solution {
    int findLowerBound(int h , List<Integer> lis)
    {
        int left = 0;
        int right = lis.size() -1;
        int lowerBound = -1;
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(h<=lis.get(mid)) right = mid-1;
            else {left = mid+1; lowerBound = mid;}
        }

        return lowerBound+1;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes ,new CustomComparator());
        int len = envelopes.length;

       List<Integer> lis = new ArrayList<>();
        lis.add(envelopes[0][1]);

        for(int i=1;i<len;i++)
        {
            int height = envelopes[i][1];
            if(height>lis.get(lis.size()-1)) lis.add(height);
            else
            {
            int lowerBound = findLowerBound(height,lis);
            lis.set(lowerBound,height);
            }
        }

        return lis.size();
    }
}