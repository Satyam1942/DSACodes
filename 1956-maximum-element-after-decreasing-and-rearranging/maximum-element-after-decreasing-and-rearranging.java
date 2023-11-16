class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] A) {
         Arrays.sort(A);
        int pre = 0;
        for (int a: A)
            pre = Math.min(pre + 1, a);
        return pre;
    }
}