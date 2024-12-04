class Solution {

    int getLastElementIndex(int [] arr, int startIndex, int endWindow) {
        int left = endWindow;
        int right = arr.length-1;
        int floorIndex = endWindow-1;
        while(left<=right) {
            int mid = (left+right)/2;
            if(arr[mid]>=arr[startIndex]) {
                right = mid-1;
            } else {
                floorIndex = mid;
                left = mid+1;
            }
        }
        return floorIndex;
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int length = arr.length;
        int startWindow = 0;
        int endWindow = length-1;

        int left = 0;
        while(left<length) {
            if(arr[left]>=arr[startWindow]) {
                startWindow = left;
            } else {
                break;
            }
            left++;
        }

        int right = length-1;
        while(right>=0) {
            if(arr[right]<=arr[endWindow]) {
                endWindow = right;
            } else {
                break;
            }
            right--;
        }

        if(endWindow<=startWindow) {
            return 0;
        }

        int subarrayRemoveLength = length-1;
        for(int i = startWindow; i>=0; i--) {
            int lastElementIndex  = getLastElementIndex(arr, i, endWindow);
            subarrayRemoveLength = Math.min(subarrayRemoveLength,lastElementIndex-i);
        }

        return Math.min(subarrayRemoveLength,Math.min(endWindow, length-startWindow-1));
    }
}

/*

    22 37 59
        31 36 53

*/