class Solution {
    double fact(int n)
    {
        if(n==1|| n==0) return 1;
        
        return ((n)*(n-1)*(fact(n-2)%(double)(1e9+7))/2.0)%(double)(1e9+7);
    }

    public int countOrders(int n) {
       int noOfSpaces = 2*n;
       long a = (long)fact(noOfSpaces)%(long)(1e9+7);
       return (int)(a);

    }
}