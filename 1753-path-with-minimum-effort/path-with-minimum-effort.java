class Tuple
{
    int curRow, curCol;
    Tuple(int curRow, int curCol)
    {
        this.curRow = curRow;
        this.curCol = curCol;
    }
}
class Solution {

    public int minimumEffortPath(int[][] heights) {
     int m = heights.length;
     int n = heights[0].length;
     int effort[][] = new int[m][n];

    for(int row[] : effort)Arrays.fill(row, (int)(1e9));

       Queue<Tuple> q = new LinkedList<>();
       int delRow[] = {-1,0,1,0};
       int delCol[] = {0,-1,0,1};

       effort[0][0] =0;
       q.add(new Tuple(0,0));

       while(!q.isEmpty())
       {
           int curRow = q.peek().curRow;
           int curCol = q.peek().curCol;
           int curEffort = effort[curRow][curCol];
           q.poll();
            if(curRow==m-1 && curCol==n-1) continue;
           
        for(int i=0;i<4;i++)
        {
            int newRow = curRow+delRow[i];
            int newCol = curCol+ delCol[i];

            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n)
            {
            int newEffort = Math.max(Math.abs(heights[curRow][curCol]-heights[newRow][newCol]),curEffort);
                if(effort[newRow][newCol]>newEffort)
                {
                    q.add(new Tuple(newRow, newCol));
                    effort[newRow][newCol] = newEffort;
                }
            }
        }
       }

        return effort[m-1][n-1];
    }   
}