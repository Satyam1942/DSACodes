class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int prefixMat[][] = new int [m][n];
        int count =0;

        for(int upRow=0;upRow<m;upRow++)
        {
            int prefixRow[] = new int[n];
            Arrays.fill(prefixRow,1);

            for(int downRow=upRow;downRow<m;downRow++)
            {
                for(int col=0;col<n;col++) 
                {
                    if(prefixRow[col]==1)  prefixRow[col]= mat[downRow][col];
                }

                int temp =0;
                for(int i=0;i<n;i++)
                {
                if(prefixRow[i]==0) {temp=0;}
                else temp+= prefixRow[i];
                count+=temp;
                }
            }
        }
    
        return count;
    }
}