class Pair
{
    int row, col;
    Pair(int row,int col)
    {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    int mini = Integer.MAX_VALUE;

    void rec(int index, int toTake, int score, Pair moreStonesArray[],Pair zeroArray[],int grid[][], 
                HashSet<Integer> indexUsed )
    {
        if(index == moreStonesArray.length)
        {
            mini = Math.min(mini,score);
            return ;
        }

        int curRow = moreStonesArray[index].row;
        int curCol = moreStonesArray[index].col;
        int val = grid[curRow][curCol];
        if(toTake==0) toTake = val-1;

        for(int i=0;i<zeroArray.length;i++)
        {
            if(indexUsed.contains(i)) continue;

            int zeroRow = zeroArray[i].row;
            int zeroCol = zeroArray[i].col;
            int dist =   Math.abs(zeroRow-curRow)+Math.abs(zeroCol-curCol);

            indexUsed.add(i);

            if(toTake==1) rec(index+1,0,score+dist,moreStonesArray,zeroArray,grid,indexUsed);
            else rec(index,toTake-1,score+dist,moreStonesArray,zeroArray,grid,indexUsed);
            
            indexUsed.remove(i);
        }    
        
    }

    public int minimumMoves(int[][] grid) {
        List<Pair> moreStonesList = new ArrayList<>();
        List<Pair> zeroList = new ArrayList<>();
        HashSet<Integer> indexUsed = new HashSet<>();

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
                if(grid[i][j]==0) zeroList.add(new Pair(i,j));
                else if(grid[i][j]>1) moreStonesList.add(new Pair(i,j));
            }
        }

        Pair[] moreStonesArray = new Pair[moreStonesList.size()];
        Pair[] zeroArray = new Pair[zeroList.size()];

        for(int i=0;i<moreStonesList.size();i++) moreStonesArray[i]=moreStonesList.get(i);
        for(int j=0;j<zeroList.size();j++) zeroArray[j]=zeroList.get(j);


         rec(0,0,0,moreStonesArray,zeroArray,grid,indexUsed);

      return mini;
    }   
}