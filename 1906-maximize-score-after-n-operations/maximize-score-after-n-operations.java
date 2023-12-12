class Solution {
    int calcGCD(int a, int b)
    {
        if(a==0) return b;
        else return calcGCD(b%a,a);
    }
    int rec(int bitMask,int count ,int n, int gcd[][], int nums[],   Integer dp[][])
    {
        if(count==n+1) return 0;
        if(dp[bitMask][count]!=null) return dp[bitMask][count];
        int maxi = 0;
        for(int i=0;i<nums.length;i++)
        {
            if((bitMask&(1<<i))>0) continue;
            bitMask|=(1<<i);
            for(int j=0;j<nums.length;j++)
            {
                if(j==i || (bitMask&(1<<j))>0) continue;
                
                int temp = count*gcd[i][j]+ rec(bitMask|(1<<j),count+1,n,gcd,nums,dp);
                maxi = Math.max(maxi,temp);
            }
            bitMask^=(1<<i);
        }
   
        return dp[bitMask][count] = maxi;
    }
    public int maxScore(int[] nums) {
        int length = nums.length;
        int gcd[][]= new int[length][length];
        for(int i=0;i<length;i++)
        {
        for(int j=0;j<length;j++)
        {
            gcd[i][j] = (nums[i]>=nums[j])? calcGCD(nums[i],nums[j]): calcGCD(nums[j],nums[i]);
            gcd[j][i]=  gcd[i][j];
        }
        }

        Integer dp[][] = new Integer[1<<14][length/2+1];
        return rec(0,1,length/2,gcd,nums,dp);
    }
}