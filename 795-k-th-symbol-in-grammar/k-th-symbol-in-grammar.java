class Solution {
    int rec(int n, int k)
    {
        if(n==1) return 0;
        int length = 1<<(n-2);
        if(k<=length) return rec(n-1,k);
        else return 1-rec(n-1,k-length);
    }
    public int kthGrammar(int n, int k) {
     return rec(n,k); 
    }
}

/*
    0 = 0 
    01 = 1
    0110 = 6
    01101001 = 105
    01101001 10010110  second half is opposite to first half
    01101001100101101001011001101001
 */