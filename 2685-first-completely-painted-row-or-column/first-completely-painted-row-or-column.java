class Pair{
    int row ,col;
    Pair(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        
        HashMap<Integer,Pair> map = new HashMap<>();
        HashMap<Integer,Integer> rowmap =new HashMap<>();
        HashMap<Integer,Integer> colmap = new HashMap<>();
        
        int m = mat.length;
        int n =mat[0].length;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                      map.put(mat[i][j],new Pair(i,j));
            }
        }
        
        int ansIndex=-1;
        for(int i=0;i<arr.length;i++)
        {
           int row =  map.get(arr[i]).row;
            int col =  map.get(arr[i]).col;
            int valrow = rowmap.getOrDefault(row,0);
            int valcol = colmap.getOrDefault(col,0);
            if(valrow+1 == n || valcol+1 == m) {ansIndex =i; break;}
            
            rowmap.put(row,valrow+1);
            colmap.put(col,valcol+1);
            
        }
        return ansIndex;
    }
}