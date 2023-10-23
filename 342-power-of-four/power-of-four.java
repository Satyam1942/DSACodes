class Solution {
    public boolean isPowerOfFour(int n) {
        int mask = 1, countZ = 0, countO = 0;
        boolean flag = false;

        for(int i=0;i<32;i++)
        {
            if((n&(1<<i))==0) 
            {
                if(!flag)
                countZ++;
            }
            else {countO++; flag = true;}
            
        }

        return countZ%2==0 && countO==1;
    }
}