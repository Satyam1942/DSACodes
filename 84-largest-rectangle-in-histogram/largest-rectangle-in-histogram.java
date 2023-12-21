class Solution {
    void nextSmaller(int heights[],int nextSmaller[])
    {
        Stack<Integer> st = new Stack<>();
        Arrays.fill(nextSmaller,heights.length);

        for(int i=0;i<heights.length;i++)
        {
                while(!st.isEmpty() && heights[i]<heights[st.peek()])
                {
                    nextSmaller[st.pop()] = i;
                }
                st.push(i);
        }

    }

     void prevSmaller(int heights[],int prevSmaller[])
    {
        Stack<Integer> st = new Stack<>();
        Arrays.fill(prevSmaller,-1);
        for(int i=heights.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && heights[i]<heights[st.peek()])
            {
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }
    }

    public int largestRectangleArea(int[] heights) {
        int nextSmaller [] = new int[heights.length];
        int prevSmaller [] = new int[heights.length];

        nextSmaller(heights,nextSmaller);
        prevSmaller(heights,prevSmaller);

        int largestArea = 0;

        for (int i = 0; i < heights.length; i++) {
            largestArea = Math.max(largestArea,((nextSmaller[i]-1)-(prevSmaller[i]+1)+1)*heights[i]);
        }

        return largestArea;
    }
}