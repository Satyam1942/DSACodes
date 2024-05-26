class Solution {
    int largestRectangleInHistogram(int rectangle[]){
        int length = rectangle.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<length;i++){
            while(!st.isEmpty() && rectangle[st.peek()]>rectangle[i]){
                int height = rectangle[st.pop()];
                int prev = (st.isEmpty())?-1:st.peek();
                int width  = i-prev-1;
                int area= height*width;
                maxArea=  Math.max(maxArea,area);
            }
            st.push(i);
        }

        
        while(!st.isEmpty()){
            int height = rectangle[st.pop()];
            int prev = (st.isEmpty())?-1:st.peek();
            int width  = length-prev-1;
            int area= height*width;
            maxArea=  Math.max(maxArea,area);
        }
        return maxArea;
    }

    int calculateLargestSubmatrix(int matrix[][]){
        int length = matrix.length;
        int width = matrix[0].length;

        int maxArea = 0;
        int cache[] = new int[width];
        for(int i=0;i<length;i++){
            for(int j=0;j<width;j++){
                if(matrix[i][j]==0)
                    cache[j] = 0;
                else
                    cache[j]+=1;
            }

            int sortedMatrix[] = new int[width];
            for(int j=0;j<width;j++)
                sortedMatrix[j] = cache[j];
            Arrays.sort(sortedMatrix);
            
            int area = largestRectangleInHistogram(sortedMatrix);
            maxArea = Math.max(maxArea,area);
        }

        return maxArea;
    }

    public int largestSubmatrix(int[][] matrix) {
        return calculateLargestSubmatrix(matrix);
    }
}