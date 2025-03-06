class Solution {
    public long coloredCells(int n) {
        return (long)(n-1)*(long)(n-1) + (long)(n)*(long)n;
    }
}