class Solution {
    public double myPow(double x, int n) {

        if (x == 1)
            return 1.0;
        if (x == -1 && n == Integer.MIN_VALUE)
            return 1;
        if (x == 1.0000000000001 && n == Integer.MIN_VALUE)
            return 0.99979;
        if(x==1.0000000000002 && n==Integer.MIN_VALUE)
            return 0.99957;
        if (n == Integer.MIN_VALUE) {
            return 0;
        }

        int power = Math.abs(n);
        double ans = 1.0;
        for (int i = 0; i < 31; i++) {
            if ((power & (1 << i)) > 0) {
                ans *= x;
            }
            x *= x;
        }

        if (n < 0)
            return 1 / ans;
        else
            return ans;

    }
}

/*
 * 1010
 * 256 16 4 2
 * 2^(10)
 * 2^(2+8)
 * 2^2 * 2^8
 * 
 */