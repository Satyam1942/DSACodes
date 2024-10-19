class Solution {
    int recursion(int n, int k) {
        if(n==1) {
            return 0;
        }

        int length = (1<<n)-1;
    
        if(k==length/2+1) {
            return 1;
        } else if(k>length/2+1) {
            return 1-recursion(n-1, (1<<(n-1))-(k-length/2)+1);
        } else {
            return recursion(n-1, k);
        }

    }
    public char findKthBit(int n, int k) {
        int bit = recursion(n,k);
        return (char)(bit+48);
    }
}

/*
    0110001

    0111001
 */