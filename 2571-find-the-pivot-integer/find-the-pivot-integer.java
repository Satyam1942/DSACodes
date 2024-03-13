class Solution {
    public int pivotInteger(int n) {
        int squareOfPivot = (n*(n+1))/2;
        double pivot = Math.sqrt(squareOfPivot);
        if(pivot==Math.ceil(pivot))
            return (int)pivot;
        else
            return -1;
    }
}