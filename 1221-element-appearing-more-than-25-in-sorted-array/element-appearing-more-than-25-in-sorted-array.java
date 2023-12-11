class Solution {
    
    int findFirstOccurence(int arr[],int val)
    {
        int left = 0;
        int right = arr.length-1;
        int firstOcc = 0;
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(arr[mid]>=val){ firstOcc= mid; right= mid-1;}
            else left = mid+1;
        }

        return firstOcc;
    }

    int findLastOccurence(int arr[],int val)
    {
        int left = 0;
        int right = arr.length-1;
        int lastOcc = right;

        while(left<=right)
        {
            int mid = (left+right)/2;
            if(arr[mid]<=val){left = mid+1; lastOcc = mid;}
            else right = mid-1;
        }

        return lastOcc;
    }

    public int findSpecialInteger(int[] arr) {
        
        int n = arr.length;
        int mainEle[] = new int[3];
        mainEle[0]= arr[n/4];
        mainEle[1]= arr[n/2];
        mainEle[2]= arr[3*n/4];

        for(int i:mainEle)
        {
            int f = findFirstOccurence(arr,i);
            int l = findLastOccurence(arr,i);
            if(l-f+1>n/4) return i;
        }
        
        return -1;
               
    }
}