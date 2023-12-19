class Solution {
    public boolean search(int[] arr, int target) {
        
        int left = 0;
        int right= arr.length-1;
        while(left<=right)
        {
            int mid = (left+right)/2;

            if(arr[mid]==target) return true;
            else if(arr[mid]>target)
            {
                if(arr[left]<=target) right = mid-1;
                else
                {
                    left++;
                }
            }
            else
            {
                if(target<=arr[right]) left =mid+1;
                else 
                {
                    right --;
                }
            }
        }


        return false;
    }
}