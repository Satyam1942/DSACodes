class Solution {
    long mod = (long)(1e9+7);
    void buildNumericPad(char numericPad[][] , int a ,int b)
    {
        char num = '1';
        for(int i=0;i<a-1;i++)
        {
            for(int j=0;j<b;j++) {numericPad[i][j] = num; num++;}
        }
        
        numericPad[a-1][0] = '*';
        numericPad[a-1][1] = '0';
        numericPad[a-1][2] = '#';
    }

    long rec(int n,char numericPad[][],int a,int b ,int row, int col,Long dp[][][])
    {
            if(n==0) return dp[n][row][col] = 1l;
           long temp = 0;
           int delRow[]  = {2,2,-2,-2,1,1,-1,-1};
           int delCol[]  = {1,-1,1,-1,2,-2,2,-2};

        if(dp[n][row][col]!=null) return dp[n][row][col];
           for(int i=0;i<8;i++)
           {
               int newRow = row+delRow[i];
               int newCol = col+delCol[i];
               if(newRow<a && newCol<b && newRow>=0 && newCol>=0 &&
                numericPad[newRow][newCol]!='*' && numericPad[newRow][newCol]!='#')
               {
                   temp= (temp+rec(n-1,numericPad,a,b,newRow,newCol,dp))%mod;
               }
           }
           return dp[n][row][col] = temp;
    }

    public int knightDialer(int n) {
        int a = 4;
        int b = 3;
        char numericPad[][] = new char[a][b];
        buildNumericPad(numericPad,a,b);
        long ans = 0;
        Long dp[][][] = new Long[n+1][4][3];

        ans= (ans+rec(n-1,numericPad,a,b,3,1,dp))%mod;
        for(int i=0;i<a-1;i++)
        {
        for(int j=0;j<b;j++)
        {
        ans= (ans+rec(n-1,numericPad,a,b,i,j,dp))%mod;
        }
        }

        return (int)ans;
    }
}