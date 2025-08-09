class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<0) {
            return false;
        }
        int setBitCount = Integer.bitCount(n);
        return setBitCount == 1;
    }
}