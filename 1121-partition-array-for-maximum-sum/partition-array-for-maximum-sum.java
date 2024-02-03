class Solution {
    int partitionArrayMaxSum(int index, int arr[], int k, Integer cache[]) {

        if (index == arr.length)
            return 0;

        if (cache[index] != null)
            return cache[index];

        int finalIndex = Math.min(arr.length - 1, index + k-1);
        int maxi = 0;
        int maxElement = 0;

        for (int i = index; i <= finalIndex; i++) {
            maxElement = Math.max(maxElement, arr[i]);
            int temp = maxElement * (i - index + 1) +
                    partitionArrayMaxSum(i + 1, arr, k,cache);
            maxi = Math.max(maxi, temp);
        }

        return cache[index] = maxi;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer cache[]= new Integer[arr.length];
        return partitionArrayMaxSum(0,arr,k,cache);
    }
}