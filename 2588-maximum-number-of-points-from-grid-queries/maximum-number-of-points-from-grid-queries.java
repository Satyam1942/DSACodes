class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int length = grid.length;
        int width = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int limitMat[][] = new int[length][width];

        int delRow[] = {-1,0,1,0};
        int delCol[] = { 0,1,0,-1};
        for(int row[]:limitMat) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int curVal = grid[0][0];
        int limit = curVal+1;
        limitMat[0][0] = limit;
        q.add(new int[]{0,0,limit});

        while(!q.isEmpty()) {
            int curRow = q.peek()[0];
            int curCol = q.peek()[1];
            int curLimit = q.peek()[2];
            q.poll();
            for(int i=0; i<4; i++) {
                int newRow = delRow[i]+curRow;
                int newCol = delCol[i]+curCol;
                boolean isValid = newRow>=0 && newCol>=0 && newRow<length && newCol<width;
                if(isValid) {
                    int newLimit = Math.max(curLimit, grid[newRow][newCol]+1);
                    if(limitMat[newRow][newCol]>newLimit) {
                        limitMat[newRow][newCol] = newLimit;
                        q.add(new int[]{newRow, newCol, newLimit});
                    }
                } 
            }
        }

    

        List<Integer> limitList = new ArrayList<>();
        for(int i=0;i<length;i++) {
            for(int j=0;j<width;j++) {
                int lim = limitMat[i][j];
                limitList.add(lim);
            }
        }
        
        Collections.sort(limitList);
       
        int numberOfQueries = queries.length;
        int ans[] = new int[numberOfQueries];
        for(int i=0; i<numberOfQueries; i++) {
            int limitVal = queries[i];
            int left = 0;
            int right = limitList.size()-1;
            int ansQuery = 0;
            while(left<=right) {
                int mid = (left+right)/2;
                if(limitList.get(mid)>limitVal) {
                    right = mid-1;
                } else {
                    left = mid+1;
                    ansQuery = mid+1;
                }
            }
            ans[i] = ansQuery;
        }

        return ans;
    }
}

/*
    1   2   3
    2   5   2
    3   5   1

    Perform BFS and enter min number along with node number into a List
    Sort the list by minNum
    Perform Binary Search for each query to know the points
    (1,2) (2,3) (2,3) (3,4) (3,4) (2,4) (1,4)
*/