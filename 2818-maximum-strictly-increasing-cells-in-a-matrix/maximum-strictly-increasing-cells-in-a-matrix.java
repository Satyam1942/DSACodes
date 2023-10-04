class Pair
{
    int val,addr;
    Pair(int val, int addr)
    {
        this.val = val;
        this.addr = addr;
    }
}

class Solution {
    public int maxIncreasingCells(int[][] mat) {
        /*
        1. Sort the matrix row wise and column wise choose a suitable data structure that 
        can help you map the row and column with value
        2. start dfs from node go to next bigger row as well as column and perform dfs again
        3. if you reach last node return 1
        4. keep on  adding 1 as you backtrack and storing in an ans matrix
        5. return largest val in ans matrix
         */

         int m = mat.length;
         int n = mat[0].length;
         
         TreeMap<Integer,List<int[]>> map =new TreeMap<>(Comparator.reverseOrder());

         for(int i=0;i<m;i++)
         {
             for(int j=0;j<n;j++)
             {
                if(!map.containsKey(mat[i][j])) map.put(mat[i][j],new ArrayList<>());
                map.get(mat[i][j]).add(new int[]{i,j});
             }
         }

        int maxValueInRow [] = new int[m];
        int maxValueInCol [] = new int[n];
        int dp[][] = new int[m][n];

        for(Map.Entry<Integer,List<int[]>> i: map.entrySet())
        {
            List<int[]> list = i.getValue();
            for(int[] j: list)
            {
                int row = j[0];
                int col = j[1];
                dp[row][col] = 1+Math.max(maxValueInRow[row],maxValueInCol[col]);
            }
            for(int[] j: list)
            {
                int row = j[0];
                int col = j[1];
                maxValueInRow[row] = Math.max(maxValueInRow[row],dp[row][col]);
                maxValueInCol[col] = Math.max(maxValueInCol[col],dp[row][col]); 
            }
        }


        int maxi = Integer.MIN_VALUE;
         for(int i=0;i<m;i++)
         {
             for(int j=0;j<n;j++) 
             {
                 maxi = Math.max(maxi,dp[i][j]);}
            }
        
        return maxi;
    }
}