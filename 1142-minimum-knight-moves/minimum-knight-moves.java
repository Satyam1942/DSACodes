class Pair
{
    int row,column;
    Pair(int row, int column)
    {
        this.row= row;
        this.column  = column;
    }
}

class Solution {
    void markVisited(HashMap<Integer,HashSet<Integer>> vis, int x ,int y)
    {
        if(!vis.containsKey(x)) vis.put(x,new HashSet<>());
        vis.get(x).add(y);
    }

    public int minKnightMoves(int x, int y) {

     int minDistance = 0;
     int delRow[] = {-2,-2,2,2,1, 1,-1,-1};
     int delCol[]=  {-1, 1,1,-1,2,-2, 2,-2};
     Queue<Pair> q = new LinkedList<>();
     HashMap<Integer,HashSet<Integer>> vis= new HashMap<>();

     q.add(new Pair(0,0));
     markVisited(vis,0,0);

     while(!q.isEmpty())
     {
         int size = q.size();
         while(size-->0)
         {
         int curRow = q.peek().row;
         int curCol = q.peek().column;
         if(curRow==x && curCol==y) return minDistance;
         q.poll();

        for(int i=0;i<8;i++)
        {
            int newRow = curRow + delRow[i];
            int newCol =  curCol+ delCol[i];
            if(!vis.containsKey(newRow) || !vis.get(newRow).contains(newCol))
            {
                q.add(new Pair(newRow,newCol));
                 markVisited(vis,newRow,newCol);
            }
        }
         
         }
        minDistance++;
     }

     return -1;
    }
}