class Solution {
    public int minimumOneBitOperations(int n) {
        boolean flag = true;
        int sum=0;
        for(int i=31;i>=0;i--)
        {
            if((n&(1<<i))!=0)
            {
                if(flag) sum+= (1<<(i+1))-1;
                else sum-= ((1<<(i+1))-1);
                flag =!flag;
            }
        }

        return sum;
    }
}
/*
    0th  bit = 1
    1st bit = 3
    2nd bit = 7
    3rd bit = 15
    nth bit = 1+2+4+..2^n= 2^n-1

    011 = 3-1 =2
    110= 7-3
    1011 = 15-3+1= 13

 */