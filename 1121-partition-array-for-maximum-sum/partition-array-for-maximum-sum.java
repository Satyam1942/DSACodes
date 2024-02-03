class Solution {
    //TABULATION APPRPOACH
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int cache[] = new int[arr.length + 1];

        for (int index = arr.length - 1; index >= 0; index--) {
            int finalIndex = Math.min(arr.length - 1, index + k - 1);
            int maxi = 0;
            int maxElement = 0;

            for (int i = index; i <= finalIndex; i++) {
                maxElement = Math.max(maxElement, arr[i]);
                int temp = maxElement * (i - index + 1) + cache[i + 1];
                maxi = Math.max(maxi, temp);
            }

            cache[index] = maxi;
        }

        return cache[0];
    }
}