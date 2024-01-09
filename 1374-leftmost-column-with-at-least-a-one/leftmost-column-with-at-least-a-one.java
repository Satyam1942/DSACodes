/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 * public int get(int row, int col) {}
 * public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int noOfRows = dimensions.get(0);
        int noOfCols = dimensions.get(1);

        int leftMost = noOfCols;
        for (int index = 0; index < noOfRows; index++) {
            int left = 0;
            int right = noOfCols-1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (binaryMatrix.get(index, mid) == 0)
                    left = mid + 1;
                else {
                    right = mid - 1;
                    leftMost = Math.min(leftMost, mid);
                }
            }
        }
        if(leftMost == noOfCols) return -1;
        return leftMost;

    }
}