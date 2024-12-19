class Solution {
    int maxPartition = 0;
    void recursion(int noOfPartition, int maxValPrevPart, int startIndex, int[] arr) {
        int length = arr.length;

        if(startIndex==length) {
            maxPartition = Math.max(maxPartition, noOfPartition);
            return ;
        }

        int maxVal = 0;
        int minVal = Integer.MAX_VALUE;

        for(int partition = startIndex; partition<length; partition++) {
            maxVal = Math.max(maxVal, arr[partition]);
            minVal = Math.min(minVal, arr[partition]);
            if(minVal<maxValPrevPart) {
                continue;
            }
            recursion(noOfPartition+1, maxVal, partition+1, arr);
        }
     }

    public int maxChunksToSorted(int[] arr) {
        int length = arr.length;
        recursion(0, -1, 0, arr);
        return maxPartition;
    }
}

/*

    1, 0, 2, 3, 4

*/