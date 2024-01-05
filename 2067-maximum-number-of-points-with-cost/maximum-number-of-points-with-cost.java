class Solution {
    public long maxPoints(int[][] points) {
        int length = points.length;
		int noOfCol = points[0].length;
	long prev[] = new long[noOfCol];
	for(int i=0;i<noOfCol;i++)prev[i] = (long) points[0][i];
	
	for(int row =1;row<length;row++)
	{
		long leftMax = 0;
		long cur[] = new long[noOfCol];
		for(int col=0;col<noOfCol;col++)
		{	
		  long deltaPoints = Math.max(prev[col],leftMax-1);
		  cur[col] = deltaPoints+points[row][col];
		  leftMax = deltaPoints;
		}
		
		long rightMax = 0;
		for(int col=noOfCol-1;col>=0;col--)
		{	
		  long deltaPoints = Math.max(prev[col],rightMax-1);
		  cur[col] = Math.max(cur[col],deltaPoints+points[row][col]);
		  rightMax = deltaPoints;
		}


		for(int i=0;i<noOfCol;i++) prev[i] = cur[i];
	}
	
	long maxPoints = 0;
	for(int col=0;col<noOfCol;col++)
	   maxPoints = Math.max(maxPoints,prev[col]);


	return maxPoints;

    }
}