/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    int binarySearchLeft(int left ,int right, MountainArray mountainArr, int target)
    {
        while(left<=right)
        {
            int mid = (left+right)/2;
            int val = mountainArr.get(mid);
            if(val<target) left = mid+1;
            else if(val>target) right = mid-1;
            else return mid;
        }
        return -1;
    }

    int binarySearchRight(int left ,int right, MountainArray mountainArr, int target)
    {
        while(left<=right)
        {
            int mid = (left+right)/2;
            int val = mountainArr.get(mid);
            if(val<target) right = mid-1;
            else if(val>target) left = mid+1;
            else return mid;
        }
        return -1;
    }

    int findPeakIndex(MountainArray mountainArr, int length)
    {
        int left = 0;
        int right = length-1;
        while(left<right)
        {
            int mid = (left+right)/2;
            if(mountainArr.get(mid+1)>mountainArr.get(mid)) left = mid+1;
            else right = mid-1;
        }
        return left;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int peakIndex =  findPeakIndex(mountainArr,length);
    
        if(target==mountainArr.get(peakIndex)) return peakIndex;

        int leftIndex = binarySearchLeft(0,peakIndex-1,mountainArr,target);
        if(leftIndex!=-1) return leftIndex;

        int rightIndex = binarySearchRight(peakIndex+1,length-1,mountainArr,target);
        return rightIndex;
    }
}