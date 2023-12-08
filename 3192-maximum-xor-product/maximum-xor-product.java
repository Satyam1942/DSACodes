class Solution {
   public int maximumXorProduct(long a, long b, int n) {
        int mod = 1000000007;
        for (int i = n - 1; i >= 0; --i) {
            long mask = (long) 1 << i;
            if ((a & mask) != 0 && (b & mask) != 0) {
                continue;
            } else if ((a & mask) != 0) {
                if (a > b) {
                    a ^= mask;
                    b |= mask;
                }
             
            } else if ((b & mask) != 0) {
                if (a < b) {
                    a |= mask;
                    b ^= mask;
                }
            } else {
                a |= mask;
                b |= mask;
            }
        }
        a = a % mod;
        b = b % mod;
        return (int) ((1L * a * b) % mod);
    }

}

/*
    a= 1 = 1 =>5
    b= 6 = 101 => 010=> 4
    0111 = 0110
    1110 = 1111
    1010

    0,8
    for max xor I need an element which has inverted bits
    if two bits are same , put the opposite there
    else whichever number is smaller set its bit
 */