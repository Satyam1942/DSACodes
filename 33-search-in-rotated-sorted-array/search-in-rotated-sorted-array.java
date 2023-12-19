class Solution {
   int getPivotIndex(int arr[])
    {
        int left = 0;
        int right = arr.length-1;
        int pivot = 0;

        while(left<right)
        {
            int mid = (left+right)/2;
            if(arr[mid]>arr[right]) left = mid+1;
            else if(arr[mid]<=arr[right])
            {
                right = mid;
                pivot = mid;
            }
        }

        pivot = right;
        return pivot;
    }

    int binarySearch(int arr[] , int left ,int right, int val)
    {
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(arr[mid]>val) right = mid-1;
            else if(arr[mid]<val) left = mid+1;
            else return mid;
        }
        return -1;
    }


    public int search(int[] nums, int target) {
        int k = getPivotIndex(nums);
        System.out.println(k);
        int indx1 = binarySearch(nums,0,k-1, target) ;
        int indx2 = binarySearch(nums,k,nums.length-1, target) ;
       return Math.max(indx1,indx2);
    }
}