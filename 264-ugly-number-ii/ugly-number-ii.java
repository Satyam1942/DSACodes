class Solution {
    public int nthUglyNumber(int n) {
       
       int uglyNum[] = new int[n];
       uglyNum[0] =1;
       int factor1 = 2, factor2 = 3, factor3= 5;
       int index1 = 0,index2= 0,index3=0;

       for(int i=1;i<n;i++)
       {
           int factor = Math.min(factor1,Math.min(factor2,factor3));
           uglyNum[i] = factor;
          if(factor == factor1) factor1=2*uglyNum[++index1];
          if(factor == factor2) factor2=3*uglyNum[++index2];
          if(factor == factor3) factor3=5*uglyNum[++index3];
        }

        return uglyNum[n-1];
    }
}

/*
   Taking minimum out of numbers which are obtained from previous ugly numbers by multiplying 2 ,3, 5
   
 */