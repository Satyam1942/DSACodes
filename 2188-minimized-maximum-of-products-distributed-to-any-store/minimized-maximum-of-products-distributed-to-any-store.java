class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int start = 1, end = Integer.MIN_VALUE, result = 1; // answer will lie between 1 and max(quantities)
        for(int quantity : quantities) {
            end = Math.max(end, quantity);
        }
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(check(quantities, n, mid)) {
                result = mid; // We have found a potential answer but need to check if we can do better
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
    
    private boolean check(int[] quantities, int n, int target) {
        int count = 0;
        for(int quantity : quantities) {
            count += quantity % target == 0 ? quantity / target : quantity / target + 1;
        }
        return count <= n;
    }
}