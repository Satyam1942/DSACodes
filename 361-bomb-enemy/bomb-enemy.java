class Solution {
    void traverseRowFront(char grid[][] , int distGrid[][])
{
int  m = grid.length;
int n = grid[0].length;
for(int i=0;i<m;i++)
{	
	int count = 0;
	for(int j=0;j<n;j++)
	{
		if(grid[i][j]=='0') distGrid[i][j]+=count;
else if (grid[i][j]=='W'){distGrid[i][j]=-1; count=0;}
else {distGrid[i][j]=-1; count+=1;}
}
}

}

void traverseRowBack(char grid[][] , int distGrid[][])
{
int  m = grid.length;
int n = grid[0].length;
for(int i=0;i<m;i++)
{	
	int count = 0;
	for(int j=n-1;j>=0;j--)
	{
		if(grid[i][j]=='0') distGrid[i][j]+=count;
else if (grid[i][j]=='W'){distGrid[i][j]=-1; count=0;}
else {distGrid[i][j]=-1; count+=1;}
}
}

}

void traverseColTop(char grid[][] , int distGrid[][])
{
int  m = grid.length;
int n = grid[0].length;

for(int i=0;i<n;i++)
{	
	int count = 0;
	for(int j=0;j<m;j++)
	{
		if(grid[j][i]=='0') distGrid[j][i]+=count;
else if (grid[j][i]=='W'){distGrid[j][i]=-1; count=0;}
else {distGrid[j][i]=-1; count+=1;}
}
}

}

void traverseColBottom(char grid[][] , int distGrid[][])
{
int  m = grid.length;
int n = grid[0].length;

for(int i=0;i<n;i++)
{	
	int count = 0;
	for(int j=m-1;j>=0;j--)
	{
		if(grid[j][i]=='0') distGrid[j][i]+=count;
else if (grid[j][i]=='W'){distGrid[j][i]=-1; count=0;}
else {distGrid[j][i]=-1; count+=1;}
}
}

}

    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int distGrid[][] = new int[m][n];

        traverseRowFront(grid, distGrid);
        traverseRowBack(grid, distGrid);

        traverseColTop(grid, distGrid);
        traverseColBottom(grid, distGrid);
        int maxEnemyKilled = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxEnemyKilled = Math.max(maxEnemyKilled, distGrid[i][j]);
            }
        }

        return maxEnemyKilled;

    }
}