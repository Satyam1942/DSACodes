class Solution {
    public int greaterCount(List<Integer> arr, int n){
        return arr.size()-(binarySearch(arr, n) + 1);
    }

    private int binarySearch(List<Integer> arr, int target) {
        int low = 0, high = arr.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private void addToSortedArray(List<Integer> arr, int target){
        int index = binarySearch(arr, target);
        arr.add(index, target);
    }

    public int[] resultArray(int[] nums) {
        int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length];

        int arr1Counter = 0;
        int arr2Counter = 0;

        List<Integer> sortedArr1 = new ArrayList<>();
        List<Integer> sortedArr2 = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            boolean cond1 = greaterCount(sortedArr1, nums[i]) > greaterCount(sortedArr2, nums[i]);
            boolean cond2 = greaterCount(sortedArr1, nums[i]) < greaterCount(sortedArr2, nums[i]);
            boolean cond3 = greaterCount(sortedArr1, nums[i]) == greaterCount(sortedArr2, nums[i]);
            if(i!=1 && (i==0 || cond1 || (cond3 && arr1Counter<=arr2Counter))) {
                arr1[arr1Counter] = nums[i];
                arr1Counter++;
                addToSortedArray(sortedArr1, nums[i]);
            }
            else if(i==1 || cond2 || cond3){
                arr2[arr2Counter] = nums[i];
                arr2Counter++;
                addToSortedArray(sortedArr2, nums[i]);
            }
        }

        int[] finalArr = new int[nums.length];
        int finalIndex = 0;
        for(int i=0; i<arr1Counter; i++){
            finalArr[finalIndex] = arr1[i];
            finalIndex++;
        }
        for(int i=0; i<arr2Counter; i++){
            finalArr[finalIndex] = arr2[i];
            finalIndex++;
        }
        return finalArr;
    }
}