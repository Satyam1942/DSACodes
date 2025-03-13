class Solution {
    void initialiseDifArray(int nums[], int difArray[], int length) {
         difArray[0] = nums[0];
        for(int i=1; i<length;i++) {
            difArray[i] = nums[i]-nums[i-1];
        }
    }

    void rangeUpdate( int difArray[], int queries[][], int k, int length) {
        for(int i=0;i<k;i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int delta = queries[i][2];
            difArray[left]-=delta;
            if(right+1<length) {
                difArray[right+1]+=delta;
            }
        }
    }

    boolean isPossible(int nums[], int k, int queries[][]) {
        int length = nums.length;
        int difArray[] = new int[length];
        int updateArray[] = new int[length];
        initialiseDifArray(nums, difArray, length);
        rangeUpdate(difArray, queries, k, length);

        for(int i=0;i<length;i++) {
            if(i==0) {
                updateArray[0] = difArray[0];
            } else {
                updateArray[i] = updateArray[i-1]+difArray[i];
            }
            if(updateArray[i]>0) {
                return false;
            }
        }

        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int length = nums.length;
        boolean allZeroes = true;
        for(int i=0;i<length;i++) {
            if(nums[i]!=0) {
                allZeroes = false;
            }
        }

        if(allZeroes) {
            return 0;
        }

        int left = 1;
        int right = queries.length;
        int minK = right+1;

        while(left<=right) {
            int mid = (left+right)/2;
            if(isPossible(nums, mid, queries)) {
                minK = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        if(minK == queries.length+1) {
            return -1;
        } else {
            return minK;
        }
    }
}

/* 
    CONCEPT of Difference Array:
    D[0] = A[0]
    D[i] = A[i]- A[i-1]

    Eg: [2, 0,  2]
    Difference Array = [2, -2,  0]
    can be used to peform range updates in O(1) time


*/