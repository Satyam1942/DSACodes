class Solution {
    int largestRectangleInHistogram(int arr[])
    {
        Stack<Integer> st = new Stack<>();
        int prevSmaller = -1, nextSmaller = arr.length;
        int maxmArea = 0;
        for(int i=0;i<arr.length;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
            {
                int height = arr[st.pop()];
                prevSmaller = (!st.isEmpty())? st.peek():-1;
                nextSmaller = i;
                maxmArea = Math.max(maxmArea,(nextSmaller-prevSmaller-1)*height);
            }
            st.push(i);
        }
     
        nextSmaller = arr.length;
        while(!st.isEmpty())
        {
            int height = arr[st.pop()];
            prevSmaller = (!st.isEmpty())? st.peek():-1;
            maxmArea = Math.max(maxmArea,(nextSmaller-prevSmaller-1)*height);
        }

        return maxmArea;
    }
    public int largestSubmatrix(int[][] matrix) {
     int m = matrix.length;
     int n = matrix[0].length;
     int dp[] = new int[n];
    
    int ans = 0;
     for(int i=0;i<m;i++)
     {
         for(int j=0;j<n;j++)
         {
             if(matrix[i][j]==0) dp[j] = 0;
             else dp[j]++;
         }
         int sortedArray[] = new int[n];
         for(int j=0;j<n;j++) sortedArray[j] = dp[j];
          Arrays.sort(sortedArray);
         
         int maxArea = largestRectangleInHistogram(sortedArray);
        ans = Math.max(ans,maxArea);
     }

        return ans;
    }
}