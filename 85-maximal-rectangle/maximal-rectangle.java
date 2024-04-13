class Solution {
    int largestRectangleInHistogram(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int length = arr.length;
        int maxArea = 0;
        for(int i=0;i<length;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                int height = arr[st.pop()];
                int width = (st.isEmpty())?i:i-st.peek()-1;
                int curArea = height*width;
                maxArea = Math.max(maxArea,curArea);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int height = arr[st.pop()];
            int width = (st.isEmpty())?length:length-1-st.peek();
            int curArea = height*width;
            maxArea = Math.max(maxArea,curArea);
        }
        
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) 
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[] = new int[n];
        int largestRectangle = 0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]=='0')
                    dp[j]=0;
                else 
                    dp[j]+=1;
            }
            
            int maxmArea = largestRectangleInHistogram(dp);
           
            largestRectangle = Math.max(largestRectangle,maxmArea);
        }
        return largestRectangle;

    }
}