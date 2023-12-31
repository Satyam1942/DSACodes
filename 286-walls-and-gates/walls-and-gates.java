class Pair {
    int row, col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public void wallsAndGates(int[][] filledRooms) {
        int m = filledRooms.length;
	int n = filledRooms[0].length;
    //Multisource BFS/Djikstra 
    Queue<Pair> q = new LinkedList<>();

    for(int i=0;i<m;i++)
	{
		for(int j=0;j<n;j++)
        {
            if(filledRooms[i][j]==0) q.add(new Pair(i,j));
        }
    }


int delRow[] = {0,1,0,-1};
int delCol[] ={1,0,-1,0};

while(!q.isEmpty())
{
 int curRow = q.peek().row;
 int curCol = q.peek().col;
 int curDist = filledRooms[curRow][curCol];
 q.poll();
 for(int i=0;i<4;i++)
{
int adjRow = curRow+delRow[i]; 
int adjCol =   curCol+delCol[i];
boolean isValid = adjRow>=0 && adjCol>=0 && adjRow<m && adjCol<n;
if(isValid && filledRooms[adjRow][adjCol]!=-1)
{
		int adjDist = curDist+1;
		if(filledRooms[adjRow][adjCol]>adjDist)
{	
q.add(new Pair(adjRow,adjCol));
	filledRooms[adjRow][adjCol] = adjDist;
}

}
}

}


    }
}